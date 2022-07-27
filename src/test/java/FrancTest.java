import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    public void equals_1Cfh_shouldBe_equal_1Chf(){
        assertThat(Money.franc(1)).isEqualTo(Money.franc(1));
    }

    @Test
    public void equals_1Chf_shouldBeNotEqual_1Usd(){
        assertThat(Money.franc(1)).isNotEqualTo(Money.dollar(1));
    }

    @Test
    public void equals_1Chf_shouldBe_notEqual_2Chf(){
        assertThat(Money.franc(1)).isNotEqualTo(Money.franc(2));
    }

    @Test
    public void multiply_2ChfTimes2_shouldBe_4Chf(){
        assertThat(Money.franc(2).times(2)).isEqualTo(Money.franc(4));
    }

    @Test
    public void multiply_3ChfTimes2_shouldBe_6Chf(){
        assertThat(Money.franc(3).times(2)).isEqualTo(Money.franc(6));
    }

    @Test
    public void plus_1ChfAnd1USD_shouldBe_2Chf(){
        assertThat(Money.franc(1).plus(Money.franc(1))).isEqualTo(Money.franc(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(Money.franc(5).plus(Money.franc(5))).isEqualTo(Money.franc(10));
    }

}
