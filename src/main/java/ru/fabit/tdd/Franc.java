package ru.fabit.tdd;

public class Franc  {
    private final int amount;

    public Franc(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Franc franc = (Franc) o;

        return amount == franc.amount;
    }

    @Override
    public int hashCode() {
        return amount;
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
