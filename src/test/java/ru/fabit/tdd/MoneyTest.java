package ru.fabit.tdd;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {
  private Map<ExchangePair, Double> currencyBoard = new HashMap<>();
  //    {
  //        currencyBoard.put(ExchangePair.getInstance(Currency.EUR, Currency.USD),1.2);
  //        currencyBoard.put(ExchangePair.getInstance(Currency.CHF, Currency.USD),2.0);
  //    }

  @Test
  public void dollar_shouldNotReturnNull() {
    assertThat(Money.dollar(1)).isNotNull();
  }

  @Test
  public void franc_shouldNotReturnNull() {
    assertThat(Money.franc(1)).isNotNull();
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
  public void equals_1Chf_shouldBe_notEqual_2Chf() {
    assertThat(Money.franc(1)).isNotEqualTo(Money.franc(2));
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
  public void plus_2ChfPlus4UsdAndRate4to1_shouldBe_12Usd() {
    currencyBoard.put(ExchangePair.getInstance(Currency.EUR, Currency.USD), 1.2);
    currencyBoard.put(ExchangePair.getInstance(Currency.CHF, Currency.USD), 2.0);

    assertThat(Money.franc(2.0).plus(Money.dollar(4.0)).asDollar(currencyBoard))
        .isEqualTo(Money.dollar(12));
  }
}
