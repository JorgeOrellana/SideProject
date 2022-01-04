package money;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MoneyShould {

    @Test
    public void shouldConvertUSDToBS() {
        // Arrange
        Money usdMoney = new Money(BigDecimal.valueOf(100), "usd");
        Money bsMoneyExpected = new Money(BigDecimal.valueOf(696), "bs");

        // Act
        Money result = MoneyUtils.convertCurrency(usdMoney);

        // Assert
        Assert.assertEquals(bsMoneyExpected.getAmount().stripTrailingZeros(), result.getAmount().stripTrailingZeros());
    }
}
