import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class FrancTest {

    @Test
    public void plus_1ChfAnd1USD_shouldBe_2Chf(){
        assertThat(Money.franc(1).plus(Money.franc(1))).isEqualTo(Money.franc(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(Money.franc(5).plus(Money.franc(5))).isEqualTo(Money.franc(10));
    }

}
