package fpinscala.ch02

object MyProgram:
  private def abs(n: Int): Int =
    if n < 0 then -n
    else n

  private def factorial(n: Int): Int =
    @annotation.tailrec
    def go(n: Int, acc: Int): Int =
      if n <= 0 then acc
      else go(n - 1, n * acc)

    go(n, 1)

  private def fib(n: Int): Int =
    @annotation.tailrec
    def go(n: Int, current: Int, next: Int): Int =
      if n <= 0 then current
      else go(n - 1, next, current + next)

    go(n, 0, 1)

  private def formatResult(name: String, n: Int, f: Int => Int) =
    val msg = "The %s of %d is %d."
    msg.format(name, n, f(n))

  @main def print(): Unit =
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("fib", 6, fib))
