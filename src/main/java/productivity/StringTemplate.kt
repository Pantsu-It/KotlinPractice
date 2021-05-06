package productivity

fun main() {
    val i = 10
    println("i = $i") // prints "i = 10"

    val s = "abc"
    println("$s.length is ${s.length}") // prints "abc.length is 3"

    val dollar = "\\ \\\\ \$s \\$s"
    println(dollar)

    val price = """
        price: ${'$'}9.99
    """.trim()
    println(price)

    val rawString = """
        This is a very cool pattern :
        ·····   ··
        ·   ·  · ·
        ·   ·    ·
        ·····  ·····
    """.trimIndent()
    println(rawString)
}