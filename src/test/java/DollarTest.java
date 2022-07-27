import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void equals_1Usd_shouldBe_equal_1Usd(){
        assertThat(Money.dollar(1)).isEqualTo(Money.dollar(1));
    }

    @Test
    public void equals_1Usd_shouldBeNotEqual_1Chf(){
        assertThat(Money.dollar(1)).isNotEqualTo(Money.franc(1));
    }

    @Test
    public void equals_1Usd_shouldBe_notEqual_2Usd(){
        assertThat(Money.dollar(1)).isNotEqualTo(Money.dollar(2));
    }

    @Test
    public void multiply_2UsdTimes2_shouldBe_4Usd(){
        assertThat(Money.dollar(2).times(2)).isEqualTo(Money.dollar(4));
    }

    @Test
    public void multiply_3UsdTimes2_shouldBe_6Usd(){
        assertThat(Money.dollar(3).times(2)).isEqualTo(Money.dollar(6));
    }

    @Test
    public void plus_1UsdAnd1USD_shouldBe_2Usd(){
        assertThat(Money.dollar(1).plus(Money.dollar(1))).isEqualTo(Money.dollar(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(Money.dollar(5).plus(Money.dollar(5))).isEqualTo(Money.dollar(10));
    }
}
