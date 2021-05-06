package collections.operations

fun main() {
    val numbers = listOf(1, 2, 3)

    val tripled = numbers.flatMap { listOf(it, it, it) }
    println(tripled)
}