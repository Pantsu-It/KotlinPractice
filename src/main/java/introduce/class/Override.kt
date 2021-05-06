package introduce.`class`

open class Shape {
    open fun draw() { /*...*/
    }

    fun fill() { /*...*/
    }
}

open class Circle() : Shape() {
    open override fun draw() { /*...*/
    }
}

open class Rectangle() : Shape() {
    final override fun draw() { /*...*/
    }
}

open class AnyRectangle : Rectangle() {
//    override fun draw() {
//        super.draw()
//    }
}

open class Car {
    open val vertexCount: Int = 0
}

class SmallCar : Car() {
    //    override val vertexCount = ""
    override val vertexCount = 4
}


interface Bird {
    val vertexCount: Int
}

class SmallBird(override val vertexCount: Int = 4) : Bird // Always has 4 vertices

class BigBird : Bird {
    override var vertexCount: Int = 0  // Can be set to any number later
}