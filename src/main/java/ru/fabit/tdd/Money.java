package ru.fabit.tdd;

public class Money {
    protected final int amount;

    protected final Currency currency;

    protected Money(int amount, Currency currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public Money times(int multiplier) {
        return new Money(this.amount * multiplier, this.currency);
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
        if (o == null || !(o instanceof Money) ) return false;

        Money money = (Money) o;

        if (amount != money.amount) return false;
        return currency == money.currency;
    }

    @Override
    public int hashCode() {
        int result = amount;
        result = 31 * result + (currency != null ? currency.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Money{" +
                "amount=" + amount +
                ", currency=" + currency +
                '}';
    }

//    public Wallet plus(Dollar dollar) {
//        return null;
//    }
}
