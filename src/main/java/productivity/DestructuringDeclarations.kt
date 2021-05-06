package productivity

fun main() {
    val (x, y, z) = arrayOf(5, 10, 15)
    val (c1, c2, c3) = arrayOf(5, 10, 15)
    println()

    val map = mapOf("Alice" to 21, "Bob" to 25)
    for ((name, age) in map) {
        println("$name is $age years old")
    }

    fun findMinMax(list: List<Int>) : Pair<Int, Int>  {
        val min = list.min() ?: -1
        val max = list.max() ?: -1
        return Pair(min, max)
    }
    val (min, max) = findMinMax(listOf(100, 90, 50, 98, 76, 83))
    println("min=$min max=$max")

    data class User(val username: String, val email: String)
    fun getUser() = User("Mary", "mary@somewhere.com")

    val user = getUser()
    val (username, email) = user
    println(username == user.component1())
    val (_, emailAddress) = getUser()
}