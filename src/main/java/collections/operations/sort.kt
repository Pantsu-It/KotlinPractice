package collections.operations

fun main() {
    val numbers = listOf(1, -2, 3, -4, 5, -6)
    println(numbers.sorted())
    println(numbers.sortedDescending())
    println(numbers.sortedBy { it % 2 })

    val charSet = setOf('a', 'b', 's', 't', 'r', 'a', 'c', 't')
    println(charSet.sorted())
}