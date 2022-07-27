package ru.fabit.tdd;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount, Currency.CHF);
    }

    public Franc plus(Franc another) {
        return Money.franc(this.amount + another.amount);
    }

}
