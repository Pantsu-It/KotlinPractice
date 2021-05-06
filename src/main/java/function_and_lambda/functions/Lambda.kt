package function_and_lambda.functions

// All examples create a function object that performs upper-casing.
// So it's a function from String to String

val upperCase1: (String) -> String = { str: String -> str.toUpperCase() }

val upperCase2: (String) -> String = { str -> str.toUpperCase() }

val upperCase3 = { str: String -> str.toUpperCase() }

// val upperCase4 = { str -> str.toUpperCase() }

val upperCase5: (String) -> String = { it.toUpperCase() }

val upperCase6: (String) -> String = String::toUpperCase

fun main() {
    println(upperCase1("hello"))
    println(upperCase2("hello"))
    println(upperCase3("hello"))
    println(upperCase5("hello"))
    println(upperCase6("hello"))
}

