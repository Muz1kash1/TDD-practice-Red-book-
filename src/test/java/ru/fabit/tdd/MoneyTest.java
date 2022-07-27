package ru.fabit.tdd;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    public void dollar_shouldNotReturnNull() {
        assertThat(Money.dollar(1)).isNotNull();
    }

}
