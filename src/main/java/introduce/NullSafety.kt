package introduce

fun main() {
    var neverNull: String = "This can't be null"
//    neverNull = null
    var nullable: String? = "You can keep a null here"
    nullable = null
    var inferredNonNull = "The compiler assumes non-null"
//    inferredNonNull = null

    val P1: Presenter?
    P1 = null
//    P1 = Presenter("111")
    val P2: Presenter?
//    P2 = null
    P2 = Presenter("222")
    val P3: Presenter?
//    P3 = null
    P3 = Presenter("333")

//    // ?: 针对的对象并不是run方法块的返回值
//    P1?.run {
//        print()
//    } ?: P2?.run {
//        print()
//    } ?: P3?.run {
//        print()
//    }
//
//    P1?.run { print() }

    P1?.ifNull(
        {},
        {}
    )
}

fun <T, R> T?.ifNull(fIf: () -> R, fElse: () -> R) = if (this == null) fIf() else fElse()

class Presenter(private val str: String) {
    fun print() : Unit {
        println(str)
//        return str
    }
}
