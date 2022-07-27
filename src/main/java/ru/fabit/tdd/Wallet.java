package ru.fabit.tdd;

import java.awt.geom.QuadCurve2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Supplier;

public class Wallet {
  private List<Money> moneyList;

  public Wallet(Money... money) {
    moneyList = List.of(money);
  }

  @Override
  public String toString() {
    return "Wallet{" + "moneyList=" + moneyList + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Wallet wallet = (Wallet) o;

    return moneyList.equals(wallet.moneyList);
  }

  public Wallet plus(Money money) {
    moneyList.add(money);
    return this;
  }

  public Money asDollar(Map<ExchangePair, Double> currencyBoard) {
    double amount = 0.0;
    for (Money money : moneyList) {
      if(currencyBoard.containsKey(ExchangePair.getInstance(money.currency, Currency.USD))){
        amount += money.amount * currencyBoard.get(ExchangePair.getInstance(money.currency, Currency.USD));
      }
    }

    return Money.dollar(amount);
  }

  @Override
  public int hashCode() {
    return moneyList.hashCode();
  }
}
