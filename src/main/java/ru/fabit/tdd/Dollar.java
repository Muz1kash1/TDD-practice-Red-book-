package ru.fabit.tdd;

public class Dollar extends Money {

    public Dollar(int amount) {
        super(amount);
    }

    public Dollar times(int multiplier) {
        return Money.dollar(this.amount * multiplier);
    }

    public Dollar plus(Dollar another) {
        return Money.dollar(this.amount + another.amount);
    }

    @Override
    public String toString() {
        return "Dollar{" +
                "amount=" + amount +
                '}';
    }
}
