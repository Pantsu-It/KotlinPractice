package collections.operations

fun main() {
    val list = listOf(0, 10, 20)
    println(list.getOrElse(-1) { 0 })
    println(list.getOrElse(10) { 0 })

    val map = mutableMapOf<String, Int?>()
    println(map.getOrElse("x") { 0 })
    println(map.getOrDefault("x", 0))

    map["x"] = 3
    println(map.getOrElse("x") { 0 })
    println(map.getOrDefault("x", 0))

    map["x"] = null
    println(map.getOrElse("x") { 0 })
    println(map.getOrDefault("x", 0))
}