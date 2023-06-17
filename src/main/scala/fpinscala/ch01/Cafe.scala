package fpinscala.ch01

class Cafe:
  def buyCoffee(cc: CreditCard, p: Payments): Coffee =
    val cup = Coffee()
    p.charge(cc, cup.price)
    cup

class CreditCard

trait Payments:
  def charge(cc: CreditCard, price: Double): Unit

class SimulatedPayments extends Payments:
  override def charge(cc: CreditCard, price: Double): Unit =
    println(s"charging $price to $cc")

class Coffee:
  val price: Double = 2.0
