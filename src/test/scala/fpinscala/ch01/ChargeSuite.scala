package fpinscala.ch01

import munit.FunSuite

class ChargeSuite extends FunSuite {
  test("coalesce") {
    // Given
    val cc1 = CreditCard()
    val cc2 = CreditCard()
    val charges = List(
      Charge(cc1, 1.0D),
      Charge(cc1, 2.0D),
      Charge(cc2, 3.0D),
      Charge(cc2, 4.0D),
    )
    // When
    val result = Charge.coalesce(charges)
    // Then
    assertEquals(result.toSet, Set(Charge(cc1, 3.0D), Charge(cc2, 7.0D)))
  }
}
