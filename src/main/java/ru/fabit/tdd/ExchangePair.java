package ru.fabit.tdd;

import java.util.Objects;

public class ExchangePair {
  private static ExchangePair instance;
  private final Currency firstCurrency;
  private final Currency secondCurrency;

  public ExchangePair(Currency firstCurrency, Currency secondCurrency) {
    this.firstCurrency = firstCurrency;
    this.secondCurrency = secondCurrency;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ExchangePair that = (ExchangePair) o;
    return firstCurrency == that.firstCurrency && secondCurrency == that.secondCurrency;
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstCurrency, secondCurrency);
  }

  public Currency getFirstCurrency() {
    return firstCurrency;
  }

  public Currency getSecondCurrency() {
    return secondCurrency;
  }
}
