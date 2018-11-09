package example

import java.time.LocalDateTime

import scala.concurrent.ExecutionContext

object Example {

  def main(args: Array[String]): Unit = {
    val ec: ExecutionContext = scala.concurrent.ExecutionContext.Implicits.global
    def now: LocalDateTime = LocalDateTime.now()

    println(now)

    ec.execute(new Runnable {
      override def run(): Unit = {
        Thread.sleep(3000)
        println(s"sleep ======> now time: $now")
        now
      }
    })

    println(now)
  }
}
