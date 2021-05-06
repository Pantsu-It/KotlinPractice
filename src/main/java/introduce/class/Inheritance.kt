package introduce.`class`

open class Fruit {
    constructor(name: String) {
        print("construct1: $name ")
    }

    constructor(name: String, color: String = "No Color") {
        print("construct2: $name ")
    }
}

class Apple(val color: String) : Fruit("apple", color)

class Peach() : Fruit("peach") {
    var color: String = "No Color";

    constructor(color: String) : this() {
        this.color = color;
    }
}


fun main() {
    val apple = Apple("black")
    apple.color
}