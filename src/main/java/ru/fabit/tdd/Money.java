package ru.fabit.tdd;

public class Money {
  protected final double amount;

  protected final Currency currency;

  protected Money(double amount, Currency currency) {
    this.amount = amount;
    this.currency = currency;
  }

  /**
   * возвращает новый доллар
   *
   * @param amount
   * @return
   */
  public static Money dollar(double amount) {
    return new Money(amount, Currency.USD);
  }

  /**
   * возвращает новый франк
   *
   * @param amount
   * @return
   */
  public static Money franc(double amount) {
    return new Money(amount, Currency.CHF);
  }

  /**
   * возвращает новый евро
   *
   * @param amount
   * @return
   */
  public static Money euro(double amount) {
    return new Money(amount, Currency.EUR);
  }

  /**
   * производит умножение денег
   *
   * @param multiplier
   * @return
   */
  public Money times(int multiplier) {
    return new Money(this.amount * multiplier, this.currency);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || !(o instanceof Money)) return false;

    Money money = (Money) o;

    if (amount != money.amount) return false;
    return currency == money.currency;
  }

  @Override
  public int hashCode() {
    int result = (int) amount;
    result = 31 * result + (currency != null ? currency.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "Money{" + "amount=" + amount + ", currency=" + currency + '}';
  }

  /**
   * Возвращает новый кошелёк с этой стопкой денег и с данной стопкой денег
   *
   * @param money
   * @return
   */
  public Wallet plus(Money money) {
    Wallet wallet = new Wallet(this, money);
    return wallet;
  }
}
