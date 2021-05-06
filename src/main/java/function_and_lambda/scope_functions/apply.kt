package function_and_lambda.scope_functions

class Person {
    var name: String = ""
    var age = 0
    var about = ""
}

// T -> T, as this
fun main() {
    val jake = Person()
    val stringDescription = jake.apply {
        name = "Jake"
        age = 30
        about = "Android developer"
    }.toString()
}