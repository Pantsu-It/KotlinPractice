package introduce

import java.util.*

fun main() {
    val store = Store()
    store.startSale()
    for (i in 1..3) {
        store.buySomething()
        Thread.sleep(1000)
    }
}

class Store {
    /**
    lateinit只能修饰变量var，不能修饰常量val
    lateinit不能对可空类型使用
    lateinit不能对java基本类型使用，例如：Double、Int、Long等
    在使用lateinit修饰的变量时，如果变量还没有初始化，则会抛出未初始化异常，报错
     */
    private lateinit var boss: String

    /**
    lazy只能对常量val使用，不能修饰变量var
    lazy的加载时机为第一次调用常量的时候，且只会加载一次（毕竟是个常量，只能赋值一次）
     */
    private val assistant: String by lazy {
        // lazy方法块只会执行一次
        if (Date().time % 2 == 0L) {
            "Jack"
        } else {
            "Jack'brother"
        }
    }

    fun startSale() {
        boss = "James Hans"
    }

    fun buySomething() {
        println("$boss is the boss")
        println("$assistant is in service")
    }
}