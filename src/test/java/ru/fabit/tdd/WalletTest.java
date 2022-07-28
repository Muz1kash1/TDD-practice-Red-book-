package ru.fabit.tdd;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class WalletTest {
  private Map<ExchangePair, Double> currencyBoard = new HashMap<>();

  @Test
  public void wallet_with1Dollar_shouldBeEqualWalletWith1Dollar() {
    assertThat(new Wallet(Money.dollar(1))).isEqualTo(new Wallet(Money.dollar(1)));
  }

  @Test
  public void wallet_with1Dollar_shouldNotBeEqualWalletWith2Dollar() {
    assertThat(new Wallet(Money.dollar(1))).isNotEqualTo(new Wallet(Money.dollar(2)));
  }

  @Test
  public void wallet_with1Euro_shouldBeEqualWalletWith1Euro() {
    assertThat(new Wallet(Money.euro(1))).isEqualTo(new Wallet(Money.euro(1)));
  }

  @Test
  public void wallet_with1Euro_shouldNotBeEqualWalletWith2Euro() {
    assertThat(new Wallet(Money.euro(1))).isNotEqualTo(new Wallet(Money.euro(2)));
  }

  @Test
  public void wallet_with1DollarAnd1Chf_shouldBeEqualWalletWith1dollarAnd1Chf() {
    assertThat(new Wallet(Money.dollar(1), Money.franc(1)))
        .isEqualTo(new Wallet(Money.dollar(1), Money.franc(1)));
  }

  @Test
  public void wallet_with1Dollar_plus_wallet_with1Chf_shouldBeEqualWalletWith1DollarAnd1Chf() {
    assertThat(Money.dollar(1).plus(Money.franc(1)))
        .isEqualTo(new Wallet(Money.dollar(1), Money.franc(1)));
  }

  @Test
  public void wallet_with1Euro_plus_wallet_with1Chf_shoulNotdBeEqualWalletWith1DollarAnd1Chf() {
    assertThat(Money.euro(1).plus(Money.franc(1)))
        .isNotEqualTo(new Wallet(Money.dollar(1), Money.franc(1)));
  }

  @Test
  public void Wallet_with2EuroAnd3ChfAnd4Dollar_asCurrencyUSD_shouldBeEqual20Dollar() {
    currencyBoard.put(new ExchangePair(Currency.EUR, Currency.USD), 2.0);
    currencyBoard.put(new ExchangePair(Currency.CHF, Currency.USD), 4.0);

    assertThat(
            Money.euro(2.0)
                .plus(Money.franc(3.0))
                .plus(Money.dollar(4))
                .asCurrency(currencyBoard, Currency.USD))
        .isEqualTo(Money.dollar(20));
  }

  @Test
  public void Wallet_with3EuroAnd5ChfAnd4Dollar_asCurrencyEUR_shouldNotBeEqual20Euro() {
    currencyBoard.put(new ExchangePair(Currency.USD, Currency.EUR), 0.5);
    currencyBoard.put(new ExchangePair(Currency.CHF, Currency.EUR), 2.0);

    assertThat(
            Money.euro(3.0)
                .plus(Money.franc(5.0))
                .plus(Money.dollar(4))
                .asCurrency(currencyBoard, Currency.EUR))
        .isNotEqualTo(Money.dollar(20));
  }

  @Test
  public void Wallet_with3EuroAnd5Chf_shouldBeEqual_Wallet_with3EuroAnd1ChfPlus4Chf() {
    currencyBoard.put(new ExchangePair(Currency.USD, Currency.EUR), 0.5);
    currencyBoard.put(new ExchangePair(Currency.CHF, Currency.EUR), 2.0);
    assertThat(
        (new Wallet(Money.euro(3), Money.franc(5))
            .equals(
                new Wallet(
                    Money.euro(3),
                    Money.franc(1).plus(Money.franc(4)).asCurrency(currencyBoard, Currency.CHF)))));
  }
}
