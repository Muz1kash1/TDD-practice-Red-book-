package ru.fabit.tdd;

import java.util.List;

public class Wallet {
    private final List<Money> moneyList;   
    public Wallet(Money ...money) {
        moneyList = List.of(money);
    }

    @Override
    public String toString() {
        return "Wallet{" +
                "moneyList=" + moneyList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Wallet wallet = (Wallet) o;

        return moneyList.equals(wallet.moneyList);
    }

    @Override
    public int hashCode() {
        return moneyList.hashCode();
    }
}
