package money;

import java.math.BigDecimal;

public class MoneyUtils {

    public static Money convertCurrency(Money money) {
        Currency bs = new BSCurrency();
        Currency usd = new USDCurrency();
        Currency brl = new BRLCurrency();
        Currency ars = new ARSCurrency();

        usd.setNextChain(brl);
        brl.setNextChain(ars);
        ars.setNextChain(bs);

        return usd.exchange(money);
    }
}
