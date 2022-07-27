package ru.fabit.tdd;

public class Franc extends Money {

    public Franc(int amount) {
        super(amount);
    }

    public Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }

    public Franc plus(Franc another) {
        return new Franc(this.amount + another.amount);
    }

    @Override
    public String toString() {
        return "Franc{" +
                "amount=" + amount +
                '}';
    }
}
