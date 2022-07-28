package ru.fabit.tdd;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
  private Map<ExchangePair, Double> currencyBoard = new HashMap<>();

  @Test
  public void dollar_shouldNotReturnNull() {
    assertThat(Money.dollar(1)).isNotNull();
  }

  @Test
  public void franc_shouldNotReturnNull() {
    assertThat(Money.franc(1)).isNotNull();
  }

  @Test
  public void euro_shouldNotReturnNull() {
    assertThat(Money.euro(1)).isNotNull();
  }

  @Test
  public void equals_1Cfh_shouldBe_equal_1Chf() {
    assertThat(Money.franc(1)).isEqualTo(Money.franc(1));
  }

  @Test
  public void equals_1Chf_shouldBeNotEqual_1Usd() {
    assertThat(Money.franc(1)).isNotEqualTo(Money.dollar(1));
  }

  @Test
  public void equals_1eur_shouldBe_equal_1eur() {
    assertThat(Money.euro(1)).isEqualTo(Money.euro(1));
  }

  @Test
  public void equals_1eur_shouldBeNotEqual_1Usd() {
    assertThat(Money.euro(1)).isNotEqualTo(Money.dollar(1));
  }

  @Test
  public void equals_1Chf_shouldBe_notEqual_2Chf() {
    assertThat(Money.franc(1)).isNotEqualTo(Money.franc(2));
  }

  @Test
  public void equals_1Eur_shouldBe_notEqual_2Eurf() {
    assertThat(Money.euro(1)).isNotEqualTo(Money.euro(2));
  }

  @Test
  public void equals_1Usd_shouldBe_equal_1Usd() {
    assertThat(Money.dollar(1)).isEqualTo(Money.dollar(1));
  }

  @Test
  public void equals_1Usd_shouldBeNotEqual_1Chf() {
    assertThat(Money.dollar(1)).isNotEqualTo(Money.franc(1));
  }

  @Test
  public void equals_1Usd_shouldBe_notEqual_2Usd() {
    assertThat(Money.dollar(1)).isNotEqualTo(Money.dollar(2));
  }

  @Test
  public void multiply_2ChfTimes2_shouldBe_4Chf() {
    assertThat(Money.franc(2).times(2)).isEqualTo(Money.franc(4));
  }

  @Test
  public void multiply_2EurTimes2_shouldBe_4Eur() {
    assertThat(Money.euro(2).times(2)).isEqualTo(Money.euro(4));
  }

  @Test
  public void multiply_3EurTimes2_shouldBe_6Eur() {
    assertThat(Money.euro(3).times(2)).isEqualTo(Money.euro(6));
  }

  @Test
  public void multiply_3ChfTimes2_shouldBe_6Chf() {
    assertThat(Money.franc(3).times(2)).isEqualTo(Money.franc(6));
  }

  @Test
  public void multiply_2UsdTimes2_shouldBe_4Usd() {
    assertThat(Money.dollar(2).times(2)).isEqualTo(Money.dollar(4));
  }

  @Test
  public void multiply_3UsdTimes2_shouldBe_6Usd() {
    assertThat(Money.dollar(3).times(2)).isEqualTo(Money.dollar(6));
  }

  @Test
  public void plus_2ChfPlus4UsdAndRate2to1_shouldBe_8Usd() {
    currencyBoard.put(new ExchangePair(Currency.EUR, Currency.USD), 1.2);
    currencyBoard.put(new ExchangePair(Currency.CHF, Currency.USD), 2.0);
    assertThat(Money.franc(2.0).plus(Money.dollar(4.0)).asCurrency(currencyBoard, Currency.USD))
        .isEqualTo(Money.dollar(8));
  }
}
