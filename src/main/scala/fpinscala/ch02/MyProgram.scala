package fpinscala.ch02

object MyProgram:
  private def abs(n: Int): Int =
    if n < 0 then -n
    else n

  private def formatAbs(x: Int) =
    val msg = "The absolute value of %d id %d"
    msg.format(x, abs(x))

  @main def printAbs(): Unit =
    println(formatAbs(-42))
