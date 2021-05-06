package classes_and_objects.classes

import java.util.concurrent.atomic.AtomicInteger

// 1.1  主构造方法至少有一个参数，这些参数必须被 var/val 修饰
// 1.2  次构造方法的参数不能被 var/val 修饰
// 2.   不能被以下关键字修饰： abstract，open, sealed or inner
// 3.1  关于 equals/hashCode/toString 方法，如果data类中明确实现 或者 父类实现并final修饰，则这些方法不会被生成；
// 3.2  关于 componentN 方法，如果父类拥有，和生成方法不兼容而无法被覆盖(final, return-type)，则会报错；

abstract class Alive(open val id: Int) {
    final override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Alive

        if (id != other.id) return false

        return true
    }

    final override fun hashCode(): Int = id
}

interface Workable {
    fun work(material: Any?): Any?
}

data class User(val name: String, override val id: Int) : Alive(id), Workable {
    companion object {
        val ID_GENERATOR = AtomicInteger()
    }

    constructor(name: String) : this(name, ID_GENERATOR.incrementAndGet())

    override fun work(material: Any?) = println("no more WORK!")
}


fun main() {
    val user = User("Alex")
    val secondUser = User("Alex", 1)
    val thirdUser = User("Max", 2)

    // 自动生成 equals()/hashCode()
    println("user == secondUser: ${user == secondUser}")
    println("user == thirdUser: ${user == thirdUser}")
    println(user.hashCode())
    println(secondUser.hashCode())
    println(thirdUser.hashCode())

    // 自动生成 toString() of the form "User(name=John, age=42)"
    println(user)

    // 支持 componentN()
    println("name = ${user.component1()}")
    println("id = ${user.component2()}")

    // 支持copy()
    println(user.copy())
    println(user.copy("Max"))
    println(user.copy(id = 2))
}