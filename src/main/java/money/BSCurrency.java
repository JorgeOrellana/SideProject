package money;

import java.math.BigDecimal;

public class BSCurrency implements Currency {
    private Currency currency;

    @Override
    public void setNextChain(Currency nextChain) {
        this.currency = nextChain;
    }

    @Override
    public Money exchange(Money money) {
        return money;
    }
}
