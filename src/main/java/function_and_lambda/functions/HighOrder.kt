package function_and_lambda.functions

// take function(s) as parameter(s) or return-value
// in a function

fun calculate(x: Int, y: Int, operation: (Int, Int) -> Int): Int {
    return operation(x, y)
}

fun sum(x: Int, y: Int) = x + y

fun square(x: Int) = x * x

fun operation(): (Int) -> Int {
    return ::square
}

fun main() {
    val sumResult = calculate(4, 5, ::sum)
    val mulResult = calculate(4, 5) { a, b -> a * b }
    println("sumResult $sumResult, mulResult $mulResult")

    val func = operation()
    println(func(2))
}