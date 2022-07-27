package ru.fabit.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WalletTest {

  @Test
  public void wallet_with1Dollar_shouldBeEqualWalletWith1Dollar() {
    assertThat(new Wallet(Money.dollar(1))).isEqualTo(new Wallet(Money.dollar(1)));
  }

  @Test
  public void wallet_with1Dollar_shouldNotBeEqualWalletWith2Dollar() {
    assertThat(new Wallet(Money.dollar(1))).isNotEqualTo(new Wallet(Money.dollar(2)));
  }

  @Test
  public void wallet_with1DollarAnd1Chf_shouldBeEqualWalletWith1dollarAnd1Chf() {
    assertThat(new Wallet(Money.dollar(1), Money.franc(1)))
        .isEqualTo(new Wallet(Money.dollar(1), Money.franc(1)));
  }
}
