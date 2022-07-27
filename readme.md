# Практика по TDD

| **Instrument** | **Shares** | **Price** | **Total** |
|----------------|------------|-----------|-----------|
| IBM            | 1000       | 25 USD    | 25000 USD |
| Novartis       | 400        | 150 CHF   | 60000 USD |
|                |            | **Total** | 65000 USD |

Задание: необходимо реализовать доменную модель для отображения заданного отчета.

Примеры использования:
```
Тест на коллекцию
Избавиться от классов Franc, Dollar
2 CHF + 4 USD = 12 USD (if rate 4:1)
2 CHF + 4 USD = 10 CHF (if rate 2:1)
2 EUR + 4 USD = 8 USD
no negative amount
to big amount (more than int)
```
