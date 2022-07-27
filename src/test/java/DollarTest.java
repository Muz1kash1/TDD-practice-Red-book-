import org.junit.jupiter.api.Test;
import ru.fabit.tdd.Money;

import static org.assertj.core.api.Assertions.assertThat;

public class DollarTest {

    @Test
    public void plus_1UsdAnd1USD_shouldBe_2Usd(){
        assertThat(Money.dollar(1).plus(Money.dollar(1))).isEqualTo(Money.dollar(2));
    }

    @Test
    public void plus_5UsdAnd5USD_shouldBe_10Usd(){
        assertThat(Money.dollar(5).plus(Money.dollar(5))).isEqualTo(Money.dollar(10));
    }
}
