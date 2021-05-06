package collections

import kotlin.math.min

fun main() {
    val list = generateSequence(1) { it + 1 }.take(350).toList()
    println(list)

    generateSequence(0) {it + 100}
        .map { it to min(it + 100, list.size) }
        .takeWhile { (start, end)-> start < list.size }
        .toList()
        .also { println(it) }


}