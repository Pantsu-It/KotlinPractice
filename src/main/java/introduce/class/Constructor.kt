package introduce.`class`

class Customer

class Contact(val id: Int, var email: String)

fun main() {

    val customer = Customer()

    val contact = Contact(1, "mary@gmail.com")

    println(contact.id)
    contact.email = "jane@gmail.com"

    val init = InitOrderDemo("my name")

    val constructor = Constructors(123)
}

class Person constructor(firstName: String)

class Person2(firstName: String) { /*...*/ }

class Person3 public constructor(name: String) { /*...*/ }

class InitOrderDemo(name: String) {
    val secondProperty = "Second property: ${name.length}".also(::println)

    val firstProperty = "First property: $name".also(::println)

    init {
        println("First initializer block that prints ${name}")
    }

    init {
        println("Second initializer block that prints ${name.length}")
    }
}

class Person4 {
    var children: MutableList<Person4> = mutableListOf()
    constructor(parent: Person4) {
        parent.children.add(this)
    }
}

class Constructors {
    init {
        println("Init block")
    }

    constructor(i: Int) {
        println("Constructor")
    }
}

class DontCreateMe private constructor () { /*...*/ }

/**
 * NOTE: On the JVM, if all of the parameters of the primary constructor have default values,
 * the compiler will generate an additional parameterless constructor which will use the default values.
 *
 * This makes it easier to use Kotlin with libraries such as Jackson or JPA that
 * create class instances through parameterless constructors.
 */

class ConstructorAllDefault(val customerName: String = "")