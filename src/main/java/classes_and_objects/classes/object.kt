package classes_and_objects.classes

fun rentPrice(standardDays: Int, festivityDays: Int, specialDays: Int): Unit {  //1

    // no class, no constructor, only a lazy instance.
    val dayRates = object {                                                     //2
        var standard: Int = 30 * standardDays
        var festivity: Int = 50 * festivityDays
        var special: Int = 100 * specialDays
    }

    val total = dayRates.standard + dayRates.festivity + dayRates.special       //3

    print("Total price: $$total")                                               //4

}

object DoAuth {                                                 //1
    fun takeParams(username: String, password: String){         //2
        println("input Auth parameters = $username:$password")
    }
}

class Bank {
    companion object Police {
        fun doWarning(speak: String) {
            println("warning $speak ...")
        }
    }
}

fun main() {
    rentPrice(10, 2, 1)                                                         //5

    DoAuth.takeParams("username", "123456")

    Bank.doWarning("「take back」")
}