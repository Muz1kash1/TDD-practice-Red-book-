import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Dollar;
import ru.fabit.tdd.Franc;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    public void equals_1Cfh_shouldBe_equal_1Chf(){
        assertThat(new Franc(1)).isEqualTo(new Franc(1));
    }

    @Test
    public void equals_1Chf_shouldBeNotEqual_1Usd(){
        assertThat(new Franc(1)).isNotEqualTo(new Dollar(1));
    }

    @Test
    public void equals_1Chf_shouldBe_notEqual_2Chf(){
        assertThat(new Franc(1)).isNotEqualTo(new Franc(2));
    }

    @Test
    public void multiply_2ChfTimes2_shouldBe_4Chf(){
        assertThat(new Franc(2).times(2)).isEqualTo(new Franc(4));
    }

    @Test
    public void multiply_3ChfTimes2_shouldBe_6Chf(){
        assertThat(new Franc(3).times(2)).isEqualTo(new Franc(6));
    }

    @Test
    public void plus_1ChfAnd1USD_shouldBe_2Chf(){
        assertThat(new Franc(1).plus(new Franc(1))).isEqualTo(new Franc(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(new Franc(5).plus(new Franc(5))).isEqualTo(new Franc(10));
    }

}
