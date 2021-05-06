package collections.operations


fun main() {
    var numbers = listOf(1, -2, 3, -4, 5, -6)
    val positives = numbers.filter { x -> x > 0 }
    val negatives = numbers.filter { it < 0 }
    numbers = numbers.filter { it < 10 }

    val words = listOf("Lets", "find", "something", "in", "collection", "somehow")

    val findFirst = words.find { it.startsWith("some") }
    val findLast = words.findLast { it.startsWith("some") }
    val nothing = words.find { it.contains("nothing") }


    val first = numbers.first()
    val last = numbers.last()
    val firstEven = numbers.first { it % 2 == 0 }
    val lastOdd = numbers.last { it % 2 != 0 }
//    throw NoSuchElementException("List contains no element matching the predicate.")

    val empty = emptyList<String>()
    val firstOrNull = empty.firstOrNull()
    val lastOrNull = empty.lastOrNull()
    val firstF = words.firstOrNull { it.startsWith('f') }
    val firstZ = words.firstOrNull { it.startsWith('z') }
    val lastF = words.lastOrNull { it.endsWith('f') }
    val lastZ = words.lastOrNull { it.endsWith('z') }

    val totalCount = numbers.count()
    val evenCount = numbers.count { it % 2 == 0 }

    println("Numbers: $numbers, min = ${numbers.min()} max = ${numbers.max()}")
    println("Empty: $empty, min = ${empty.min()}, max = ${empty.max()}")
}