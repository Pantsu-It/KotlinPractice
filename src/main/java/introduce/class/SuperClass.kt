package introduce.`class`

open class Rectangle1 {
    open fun draw() { println("Drawing a rectangle") }
    val borderColor: String get() = "black"
}

class FilledRectangle : Rectangle1() {
    override fun draw() {
        super.draw()
        println("Filling the rectangle")
    }

    val fillColor: String get() = super.borderColor
}

fun main() {
    var filledRectangle = FilledRectangle()
    println(filledRectangle.fillColor)
}