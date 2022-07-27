package ru.fabit.tdd;

public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount, Currency.USD);
    }

    public Dollar plus(Dollar another) {
        return Money.dollar(this.amount + another.amount);
    }

}
