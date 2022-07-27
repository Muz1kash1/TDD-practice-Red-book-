package ru.fabit.tdd;

import java.util.Objects;

public class ExchangePair {
  private final Currency firstCurrency;
  private final Currency secondCurrency;

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

  public ExchangePair(Currency firstCurrency, Currency secondCurrency) {
    this.firstCurrency = firstCurrency;
    this.secondCurrency = secondCurrency;
  }

}
