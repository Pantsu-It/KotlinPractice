package coroutines

import kotlinx.coroutines.*

object Async1 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking<Unit> {
    val time = measureTimeMillis {
      val one = async(start = CoroutineStart.LAZY) { doSomethingUsefulOne() }
      val two = async(start = CoroutineStart.LAZY) { doSomethingUsefulTwo() }
      // some computation
      one.start() // start the first one
      two.start() // start the second one
      println("The answer is ${one.await() + two.await()}")
    }
    println("Completed in $time ms")
  }

  suspend fun doSomethingUsefulOne(): Int {
    delay(1000L) // pretend we are doing something useful here
    return 13
  }

  suspend fun doSomethingUsefulTwo(): Int {
    delay(1000L) // pretend we are doing something useful here, too
    return 29
  }
}

object Async2 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val sum = failedConcurrentSum()
    println("sum:$sum")
  }

  suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async {
      delay(1000)
      42
    }
    val two = async {
      delay(1000)
      51
    }
    one.await() + two.await()
  }
}

// If sub-coroutine encounters one exception,
// another sub-coroutine(s) and parent-coroutine will be cancel.
object Async3 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking<Unit> {
    try {
      failedConcurrentSum()
    } catch (e: ArithmeticException) {
      println("Computation failed with ArithmeticException")
    }
  }

  suspend fun failedConcurrentSum(): Int = coroutineScope {
    val one = async<Int> {
      try {
        delay(Long.MAX_VALUE) // Emulates very long computation
        42
      } finally {
        println("First child was cancelled")
      }
    }
    val two = async<Int> {
      println("Second child throws an exception")
      throw ArithmeticException()
    }
    one.await() + two.await()
  }
}