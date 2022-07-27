package ru.fabit.tdd;

import java.util.Objects;

public class ExchangePair {
  private static ExchangePair instance;
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

  private ExchangePair(Currency firstCurrency, Currency secondCurrency) {
    this.firstCurrency = firstCurrency;
    this.secondCurrency = secondCurrency;
  }
  public static ExchangePair getInstance(Currency firstCurrency, Currency secondCurrency){
    if (instance == null){
      instance = new ExchangePair(firstCurrency,secondCurrency);
    }
    return instance;
  }

}
