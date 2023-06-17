package fpinscala.ch01

import munit.FunSuite

class CafeSuite extends FunSuite {
  test("buyCoffee") {
    // Given
    val cc = CreditCard()
    val cafe = Cafe()
    // When
    val (cup, charge) = cafe.buyCoffee(cc)
    // Then
    assertEquals(cup.price, 2.0D)
    assertEquals(charge, Charge(cc, cup.price))
  }

  test("buyCoffees") {
    // Given
    val cc = CreditCard()
    val cafe = Cafe()
    // When
    val (cups, charge) = cafe.buyCoffees(cc, 12)
    // Then
    assertEquals(cups.map(_.price).sum, 24.0D)
    assertEquals(charge, Charge(cc, cups.map(_.price).sum))
  }
}
