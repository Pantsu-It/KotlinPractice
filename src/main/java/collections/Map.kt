package collections

fun main() {

//    val map = mapOf("key" to 42)
//    println("${map["key"]}  ${map["key2"]}")
//
////    val value3: Int = map.getValue("key")
////    java.util.NoSuchElementException
//    val mapWithDefault = map.withDefault { 1000 }
//    val value4 = mapWithDefault.getValue("key2")
//    println("value2: ${mapWithDefault["key2"]}")
//    println("value2: ${mapWithDefault.get("key2")}")                // equal To []
//    println("value2: ${mapWithDefault.getValue("key2")}")      // with default value
//    println("value2: ${mapWithDefault.getOrDefault("key2", 123)}")
//
//    try {
//        map.getValue("anotherKey")                              // throw exception
//    } catch (e: NoSuchElementException) {
//        println("Message: $e")
//    }

    val map = mutableMapOf("key" to 0)
    var count = map["key1"] ?: 0
    count++
    println(map)
}