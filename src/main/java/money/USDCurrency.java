package money;

import java.math.BigDecimal;

public class USDCurrency implements  Currency{
    private static BigDecimal EXCHANGE_RATE = BigDecimal.valueOf(6.96);
    private Currency currency;


    @Override
    public void setNextChain(Currency nextChain) {
        this.currency = nextChain;
    }

    @Override
    public Money exchange(Money money) {
        if ("USD".equalsIgnoreCase(money.getCurrency())) {
            Money moneyResult = new Money(EXCHANGE_RATE.multiply(money.getAmount()), "bs");
            System.out.println("Exchange " + money.getAmount() + " " + money.getCurrency() + " to " + moneyResult.getAmount() + " " + moneyResult.getCurrency());
            return moneyResult;
        } else {
            return this.currency.exchange(money);
        }
    }
}
