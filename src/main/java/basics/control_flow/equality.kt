package basics.control_flow

fun main() {

    val authors = setOf("Shakespeare", "Hemingway", "Twain")
    val writers = setOf("Twain", "Shakespeare", "Hemingway")

    println(authors == writers)
    println(authors === writers)
}