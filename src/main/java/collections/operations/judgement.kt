package collections.operations

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)

    val anyNegative = numbers.any { it < 0 }
    val anyGT6 = numbers.any { it > 6 }

    val allEven = numbers.all { it % 2 == 0 }
    val allLess6 = numbers.all { it < 6 }

    val noneSingular = numbers.none { it % 2 == 1 }
    val noneGT6 = numbers.none { it > 6 }
}