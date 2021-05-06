package function_and_lambda.scope_functions

// T -> R, as it
fun main() {
    var str = "i'm rich man"
    str.split(" ").joinToString()
        .let {
            println(it)
            it.length
        }
        .let {
            println(it)
        }
}