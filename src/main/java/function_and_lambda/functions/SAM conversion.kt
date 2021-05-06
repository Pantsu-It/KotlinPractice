package function_and_lambda.functions


// In Java，SAM can be convert to lambda
fun doActionJava(action: ActionJava) {
    action.run()
}

// In Kotlin, SAM not
fun doActionKt(action: ActionKt) {
    action.run()
}

fun doActionKt2(action: ActionKt2) {
    action.run()
}

interface ActionKt {
    fun run()
}

// whereas, Kotlin provides `fun interface`
fun interface ActionKt2 {
    fun run()
}


fun main() {
    doActionJava {
        println("do Action")
    }
//    doActionKt {
//        println("do Action")
//    }
    doActionKt2 {
        println("do Action")
    }
}