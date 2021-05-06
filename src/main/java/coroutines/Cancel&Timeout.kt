package coroutines

import kotlinx.coroutines.*


object Cancel1 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val job = launch {
      repeat(1000) { i ->
        println("job: I'm sleeping $i ...")
        delay(500L)
      }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancel() // 取消该作业
    job.join() // 等待作业执行结束
    // job.cancelAndJoin() // cancel+join
    println("main: Now I can quit.")
  }
}

object Cancel2 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val startTime = System.currentTimeMillis()
    val job = launch(Dispatchers.Default) {
      var nextPrintTime = startTime
      var i = 0
      while (i < 5) { // 一个执行计算的循环，只是为了占用 CPU
        // 每秒打印消息两次
        if (System.currentTimeMillis() >= nextPrintTime) {
          println("job: I'm sleeping ${i++} ...")
          nextPrintTime += 500L
        }
      }
    }
    delay(1300L) // 等待一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消一个作业并且等待它结束
    println("main: Now I can quit.")
  }
}

object Cancel3 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val job = launch {
      try {
        repeat(1000) { i ->
          println("job: I'm sleeping $i ...")
          delay(500L)
        }
      } finally {
        println("job: I need a second to finish")
        // 在withContext中挂起一个被取消的协程，否则会抛出CancellationException
        withContext(NonCancellable) {
          delay(1000)
        }
        println("job: I'm running finally")
      }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("main: Now I can quit.")
  }
}

object Cancel4 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val job = launch {
      try {
        repeat(1000) { i ->
          println("job: I'm sleeping $i ...")
          delay(500L)
        }
      } finally {
        println("job: I need a second to finish")
        // 挂起一个被取消的协程
        withContext(NonCancellable) {
          delay(1000)
        }
        println("job: I'm running finally")
      }
    }
    delay(1300L) // 延迟一段时间
    println("main: I'm tired of waiting!")
    job.cancelAndJoin() // 取消该作业并且等待它结束
    println("main: Now I can quit.")
  }
}

object Timeout {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val result = withTimeout(1300L) {
      repeat(1) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
      "Done"
    }
    println("Result:$result")
    // Exception in thread "main" kotlinx.coroutines.TimeoutCancellationException: Timed out waiting for 1300 ms
  }
}

object TimeOut2 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val result = withTimeoutOrNull(1300L) {
      repeat(1000) { i ->
        println("I'm sleeping $i ...")
        delay(500L)
      }
      "Done"
    }
    println(
        if (result != null)
          "Result:$result"
        else
          "TimeOut and result=null"
    )
  }
}

object TimeOut3 {
  var acquired = 0

  class Resource {
    init { acquired++ } // Acquire the resource
    fun close() { acquired-- } // Release the resource
  }

  @JvmStatic
  fun main(args: Array<String>) {
    runBlocking {
      repeat(100_000) { // Launch 100K coroutines
        launch {
          val resource = withTimeout(60) { // Timeout of 60 ms
            delay(58) // Delay for 50 ms
            Resource() // Acquire a resource and return it from withTimeout block
          }
          resource.close() // Release the resource
        }
      }
    }
    // Outside of runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired
  }
}

object TimeOut4 {
  var acquired = 0

  class Resource {
    init { acquired++ } // Acquire the resource
    fun close() { acquired-- } // Release the resource
  }

  @JvmStatic
  fun main(args: Array<String>) {
    runBlocking {
      repeat(100_000) { // Launch 100K coroutines
        launch {
          var resource: Resource? = null // Not acquired yet
          try {
            withTimeout(60) { // Timeout of 60 ms
              delay(58) // Delay for 50 ms
              resource = Resource() // Store a resource to the variable if acquired
            }
            // We can do something else with the resource here
          } finally {
            resource?.close() // Release the resource if it was acquired
          }
        }
      }
    }
    // Outside of runBlocking all coroutines have completed
    println(acquired) // Print the number of resources still acquired
  }
}


fun printThread(prefix: String = "♦️") {
  println("$prefix:Current thread name: ${Thread.currentThread().name}")
}

inline fun measureTimeMillis(task: ()->Unit): Long {
  val start = System.currentTimeMillis()
  task()
  return System.currentTimeMillis() - start
}