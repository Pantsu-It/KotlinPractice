package basics.control_flow

fun main() {
    fun max(a: Int, b: Int) = if (a > b) a else b
    println(max(99, -42))

    fun compare(a: Int, b: Int) = if (a > b) 1 else if (a < b) -1 else 0
    println(compare(3, -4))
}