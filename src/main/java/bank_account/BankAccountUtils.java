package bank_account;

import element.AbstractElement;
import money.Money;

public final class BankAccountUtils {

    public static final boolean verifySavingAccountAmountToBuy(BankAccountManagerBuilder bankAccountManagerBuilder, BankEnum bank, AbstractElement element) {

        Money totalAmount = bankAccountManagerBuilder.getResidueFromSavingAccount(bank);

        return totalAmount.getAmount().compareTo(element.price().getAmount()) >= 0;
    }
}
