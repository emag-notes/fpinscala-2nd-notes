package fpinscala.ch01

import munit.FunSuite

class CafeSuite extends FunSuite {
  test("buyCoffee") {
    // Given
    val cc = CreditCard()
    val p = SimulatedPayments()
    val cafe = Cafe()
    // When
    val cup = cafe.buyCoffee(cc, p)
    // THen
    assertEquals(cup.price, 2.0D)
  }
}
