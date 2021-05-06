package classes_and_objects.classes

interface Interface {
    fun print()
}

class Outer {
    val content: String = "XXX"

    init {
        Nested().print()
        Inner().print()
        object : Interface {
            override fun print() {
                print("im anonymous, outer params is $content")
            }
        }.print()
    }

    class Nested {
        fun print() = println("im nested, can't access outer params!")
    }

    inner class Inner {
        fun print() = print("im inner, outer params is $content")
    }
}