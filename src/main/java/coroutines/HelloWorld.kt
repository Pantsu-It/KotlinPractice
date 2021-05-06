package coroutines

import kotlinx.coroutines.*

// Bridging blocking and non-blocking worlds
object HelloWorld {
  @JvmStatic
  fun main(args: Array<String>) {
    GlobalScope.launch {
      delay(1000L)
      println("World!")
    }
    runBlocking {
      println("Hello,")
      delay(2000L)
    }
  }
}

object HelloWorld2 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking<Unit> {
    GlobalScope.launch {
      delay(1000L)
      println("World!")
    }
    println("Hello,")
    delay(2000L)
  }
}

// Waiting for a job
object HelloWorld3 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val job = GlobalScope.launch {
      delay(1000L)
      println("World!")
    }
    println("Hello,")
    job.join()
  }
}

// Structured concurrency
object HelloWorld4 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    launch {
      delay(1000L)
      println("World!")
    }
    println("Hello,")
  }
}


// RunBlocking is a regular function and coroutineScope is a suspending function.
// They both wait for their body and all its children to complete
object HelloWorld5 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking { // this: CoroutineScope
    launch {
      delay(200L)
      println("Task from runBlocking")
    }

    coroutineScope { // Creates a coroutine scope
      launch {
        delay(500L)
        println("Task from nested launch")
      }

      delay(100L)
      println("Task from coroutine scope") // This line will be printed before the nested launch
    }

    println("Coroutine scope is over") // This line is not printed until the nested launch completes
  }
}

// Extract function refactoring
// 1. make your `first suspending function`
// 2. pass an explicit `CoroutineScope` as a field
object HelloWorld6 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    launch { doWorld() }
    println("Hello,")
  }

  suspend fun doWorld() {
    delay(1000L)
    println("World!")
  }
}


// Like Daemon Thread
object GlobalCoroutines {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    GlobalScope.launch {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
    }
    delay(1300L) // just quit after delay
  }
}