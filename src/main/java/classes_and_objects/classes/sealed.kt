package classes_and_objects.classes

// sealed 和 enum 相似，类型的集合是有限的，区别在于：
// enum 中每个枚举常量都是一个单例；
// sealed 中每个子类可以拥有多个实例。

// Note that all subclasses must be declared in the same file.
sealed class Mammal(val name: String)

class Cat(val catName: String) : Mammal(catName)
class Human(val humanName: String, val job: String) : Mammal(humanName)

fun greetMammal(mammal: Mammal): String {
    // `else` statement is unnecessary
    // this works only if you use when as an expression (using the result) and not as a statement.
    return when (mammal) {
        is Human -> "Hello ${mammal.name}; You're working as a ${mammal.job}"
        is Cat -> "Hello ${mammal.name}"
    }
}

fun main() {
    println(greetMammal(Cat("Snowy")))
}