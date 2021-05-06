package classes_and_objects.delegation

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

class Lazy {
    val lazyStr: String by lazy {
        "lazy timestamp: ${System.currentTimeMillis()}"
    }
}

class AccessorX {
    var p: String by DelegateX()
}

class DelegateX {
    operator fun getValue(thisRef: Any?, prop: KProperty<*>): String {
        return "getValue：'${prop.name}'"
    }

    operator fun setValue(thisRef: Any?, prop: KProperty<*>, value: String) {
        println("$value setValue to ${prop.name}")
    }
}

class DelegatesX {
    var notNullString: String by Delegates.notNull()

    var vetoableInteger: Int by Delegates.vetoable(
        0,
        onChange = { _, oldValue, newValue ->
            if (newValue > oldValue) return@vetoable true
            println("veto change from $oldValue to $newValue")
            return@vetoable false
        }
    )

    var switch: Boolean by Delegates.observable(
        false,
        onChange = { _, oldValue, newValue ->
            println("changed from $oldValue to $newValue")
        }
    )
}

// single abstract method conversion
// 为了解决：目前的 SAM 转换只对 Java 生效
fun interface PropertyDelegateProvider<T, D> {
    operator fun provideDelegate(
        thisRef: T,
        property: KProperty<*>,
    ): D
}

fun main() {
    // lazy 委托
    val lazy = Lazy()
    println("first access: ${lazy.lazyStr}")
    println("second access: ${lazy.lazyStr}")

    // accessor 委托
    val e = AccessorX()
    println(e.p)
    e.p = "NEW"

    val delegatesX = DelegatesX()

    // nonNull 委托
//    println(delegatesX.notNullString)   // unsafe
    delegatesX?.notNullString = "XXX"   // safe
    delegatesX.notNullString = "XXX"
    println(delegatesX.notNullString)

    // vetoable 委托
    delegatesX.vetoableInteger = 1
    delegatesX.vetoableInteger = 2
    delegatesX.vetoableInteger = 0
    println("final value is ${delegatesX.vetoableInteger}")

    // observable 委托
    delegatesX.switch = false
    delegatesX.switch = true

    // property 委托
    val provider = PropertyDelegateProvider { thisRef: Any?, property ->
        object : ReadWriteProperty<Any?, Int> {
            var innerValue: Int = 0

            override fun setValue(thisRef: Any?, property: KProperty<*>, value: Int) {
                println("setValue: $value")
                innerValue = value
            }

            override fun getValue(thisRef: Any?, property: KProperty<*>): Int {
                return innerValue + 100
            }
        }
    }
    var delegate: Int by provider
    delegate = 24
    println("getValue: $delegate")
}