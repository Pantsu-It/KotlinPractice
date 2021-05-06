package coroutines

import kotlinx.coroutines.*
import java.util.concurrent.atomic.AtomicLong
import kotlin.concurrent.thread


// Coroutines ARE light-weight﻿
object CompareWithThread {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
      launch {
        delay(5000L)
        print(".")
      }
    }
  }
}

object CompareWithThread2 {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    repeat(100_000) { // launch a lot of coroutines
      thread {
        Thread.sleep(5000L)
        print(".")
      }
    }
  }
}


object CompareWithThread3 {
  @JvmStatic
  fun main(args: Array<String>) {
    val c = AtomicLong()

    for (i in 1..1_000_000L)
      thread(start = true) {
        c.addAndGet(i)
      }

    println(c.get())
  }
}

object CompareWithThread4 {
  @JvmStatic
  fun main(args: Array<String>) {
    val c = AtomicLong()

    for (i in 1..1_000_000L)
      GlobalScope.launch {
        c.addAndGet(i)
      }

    println(c.get())
  }
}

// Async: returning a value from a coroutine﻿
object Async {
  @JvmStatic
  fun main(args: Array<String>) = runBlocking {
    val deferred = (1..1_000_000).map { n ->
      GlobalScope.async {
        delay(1000)
        n
      }
    }
    val sum = deferred.sumOf { it.await().toLong() }
    println(sum)
  }
}


