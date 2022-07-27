package ru.fabit.tdd;

public class Dollar {
    private final int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        return this.amount == ((Dollar) obj).amount;
    }

    public Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    public Dollar plus(Dollar another) {
        return new Dollar(this.amount + another.amount);
    }

    @Override
    public String toString() {
        return "Dollar{" +
                "amount=" + amount +
                '}';
    }
}
