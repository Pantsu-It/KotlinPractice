package function_and_lambda.scope_functions

// T -> R, as this
fun main() {
    fun getNullableLength(ns: String?) {
        println("for \"$ns\":")
        ns?.run {
            println("\tis empty? " + isEmpty())
            println("\tlength = $length")
            length
        }
    }
    getNullableLength(null)
    getNullableLength("")
    getNullableLength("some string with Kotlin")

    val str = "I'm very hard !"
    str.run {  }
        .run {  }
}