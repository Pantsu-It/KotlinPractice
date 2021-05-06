package basics.control_flow.loops

fun main() {
//    forInCollection()
//    forInRange()
    multiLoop()
}

fun multiLoop() {
    val iterable = (1..5) + (1..5)
    val iterable2 = 1..2
    loop1@ for(value in iterable) {
        loop2@ for (value2 in iterable2) {
            if (value >= 5) break@loop2
            val number = value * 10 + value2
            print("$number ")
        }
    }
}

fun forInRange() {
    for (i in 1..10) {
        print("$i ")
    }
}

fun forInCollection() {
    // list和set的遍历
    val cakes = listOf("carrot", "cheese", "chocolate")
    for (cake in cakes) {
        println("Yummy, it's a $cake cake!")
    }
    val fruits = setOf("apple", "pear", "chocolate")
    for (fruit in fruits) {
        if (fruit !in cakes) {
            println(fruit)
        }
    }
    // map的for遍历相当于遍历entries()
    val birds = mapOf("bird1" to "red", "bird2" to "yellow")
    for (bird in birds) {
        println(" ${bird.value} ${bird.key} is flying")
    }
}
