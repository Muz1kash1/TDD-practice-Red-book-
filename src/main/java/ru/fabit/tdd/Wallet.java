package ru.fabit.tdd;

import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class Wallet {
  private final List<Money> moneyList;

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

  public void plus(Money money) {
    moneyList.add(money);
  }

  public Money asDollar(Map<ExchangePair, Double> currencyBoard) {

    AtomicReference<Double> amount = new AtomicReference<>((double) 0);
    for (Money money : moneyList) {
      currencyBoard.forEach((pair,chart) -> {
        if (pair.equals(new ExchangePair(money.currency,Currency.USD))){
          amount.updateAndGet(v -> new Double((double) (v + money.amount
                  * chart)));
        }
      });



    }
    return Money.dollar(amount.get());
  }

  @Override
  public int hashCode() {
    return moneyList.hashCode();
  }
}
