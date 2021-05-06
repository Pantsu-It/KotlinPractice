package function_and_lambda.scope_functions

// T -> T, as it
fun main() {
    data class Person(val name: String, val age: Int, val job: String)

    val jake = Person("Jake", 30, "Android developer")
        .also {
            println(it)
        }
}