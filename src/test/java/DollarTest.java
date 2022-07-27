import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Dollar;
import ru.fabit.tdd.Franc;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void equals_1Usd_shouldBe_equal_1Usd(){
        assertThat(new Dollar(1)).isEqualTo(new Dollar(1));
    }

    @Test
    public void equals_1Usd_shouldBeNotEqual_1Chf(){
        assertThat(new Dollar(1)).isNotEqualTo(new Franc(1));
    }

    @Test
    public void equals_1Usd_shouldBe_notEqual_2Usd(){
        assertThat(new Dollar(1)).isNotEqualTo(new Dollar(2));
    }

    @Test
    public void multiply_2UsdTimes2_shouldBe_4Usd(){
        assertThat(new Dollar(2).times(2)).isEqualTo(new Dollar(4));
    }

    @Test
    public void multiply_3UsdTimes2_shouldBe_6Usd(){
        assertThat(new Dollar(3).times(2)).isEqualTo(new Dollar(6));
    }

    @Test
    public void plus_1UsdAnd1USD_shouldBe_2Usd(){
        assertThat(new Dollar(1).plus(new Dollar(1))).isEqualTo(new Dollar(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(new Dollar(5).plus(new Dollar(5))).isEqualTo(new Dollar(10));
    }
}
