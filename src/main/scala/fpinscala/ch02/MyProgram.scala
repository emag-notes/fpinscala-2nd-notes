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

  private def findFirstV1(ss: Array[String], key: String): Int =
    @annotation.tailrec
    def loop(n: Int): Int =
      if n >= ss.length then -1
      else if ss(n) == key then n
      else loop(n + 1)
    loop(0)

  private def findFirstV2[A](as: Array[A], p: A => Boolean): Int =
    @annotation.tailrec
    def loop(n: Int): Int =
      if n >= as.length then -1
      else if p(as(n)) then n
      else loop(n + 1)
    loop(0)

  private def isSorted[A](as: Array[A], gt: (A, A) => Boolean) : Boolean =
    @annotation.tailrec
    def loop(n: Int): Boolean =
      if n >= as.length - 1 then true
      else if gt(as(n), as(n + 1)) then false
      else loop(n + 1)
    loop(0)


  @main def run(): Unit =
    println(formatResult("absolute value", -42, abs))
    println(formatResult("factorial", 7, factorial))
    println(formatResult("fib", 6, fib))
    println(findFirstV1(Array("A", "B", "C"), "B"))
    println(findFirstV2(Array(1, 2, 3), _ == 3))
    println(isSorted(Array(1, 2, 3), _ > _))
    println(isSorted(Array(1, 2, 1), _ > _))
    println(isSorted(Array(3, 2, 1), _ < _))
    println(isSorted(Array(1, 2, 3), _ < _))
