package ru.fabit.tdd;

public abstract class Money {
    protected final int amount;

    protected Money(int amount) {
        this.amount = amount;
    }

    public static Dollar dollar(int amount) {
        return new Dollar(amount);
    }

    public static Franc franc(int amount) {
        return new Franc(amount);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Money dollar = (Money) o;

        return amount == dollar.amount;
    }

    @Override
    public int hashCode() {
        return amount;
    }

}
