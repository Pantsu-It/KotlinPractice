package basics.control_flow.loops

fun main() {
    // forEach中不能使用continue和break
//    foreachWithReturn()
    // 使用return@loopXX可以选择性返回
    foreachWithDoubleReturn()
}

fun foreachWithReturn() {
    val iterable = 1..10
    run outside@{
        iterable.forEach { value ->
            // return 将返回整个方法
//            if (value == 5) return
            // return@forEach 相当于loop中的continue
            if (value == 5) return@forEach
            // return@outside 相当于loop中的break
            if (value == 5) return@outside
            print("$value ")
        }
    }
    println(" after forEach")
}

fun foreachWithDoubleReturn() {
    val iterable = (0..2)
    val iterable2 = 1..10
    iterable.forEach loop1@{ value ->
        iterable2.forEach loop2@{ value2 ->
            val number = value * 10 + value2
            // continue结束外层lambda
//            if (number == 11) return@loop1
            // continue结束内层lambda
            if (number == 11) return@loop2
            print("$number ")
        }
    }
    println(" after forEach")
}