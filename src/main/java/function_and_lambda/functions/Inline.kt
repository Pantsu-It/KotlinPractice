package function_and_lambda.functions

fun main() {
    Human("James").eatLunch {
        println("eat rice!!")
        return
        println("...")
    }
}

var function: () -> Unit = {}

fun doFunction(func: () -> Unit) {
    func.invoke()
}

inline fun Human.eatLunch(/*noinline*/ eatMain: () -> Unit) {
    println("start")
    eatMain()
    println("finish")
}

data class Human(val name: String)


//    listOf(1, 2, 3).forEach {
//        if (it == 2) {
//            break
//        }
//    }