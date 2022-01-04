package bank_account;

import element.AbstractElement;
import money.Money;
import money.MoneyUtils;
import person.Person;
import sun.jvm.hotspot.gc.parallel.PSYoungGen;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountManagerBuilder {

    private Person person;
    private Map<BankEnum, BankAccountManager> accountManager;

    public BankAccountManagerBuilder(Person person) {
        this.person = person;
        this.accountManager = new HashMap<>();
    }

    public BankAccountManagerBuilder addFixedAccount(BankEnum bank, double amount, String currency) {
        if (accountManager.isEmpty() || accountManager.get(bank) == null) {
            BankAccountManager bankManager =  new BankAccountManager(bank, person, currency);
            Money money = new Money(BigDecimal.valueOf(amount), currency);
            bankManager.addFixedAccount(AccountEnum.FIXED, new AbstractFixedAccount(money, person));
            accountManager.put(bank, bankManager);
        } else {
            Money money = new Money(BigDecimal.valueOf(amount), currency);
            accountManager.get(bank).addFixedAccount(AccountEnum.FIXED, new AbstractFixedAccount(money, person));
        }
        return this;
    }

    public BankAccountManagerBuilder addSavingAccount(BankEnum bank, double amount, String currency) {
        if (accountManager.isEmpty() || accountManager.get(bank) == null) {
            BankAccountManager bankManager =  new BankAccountManager(bank, person, currency);
            Money money = new Money(BigDecimal.valueOf(amount), currency);
            bankManager.addWithdrawableAccount(AccountEnum.SAVING, new SavingAccount(money, person));
            accountManager.put(bank, bankManager);
        } else {
            Money money = new Money(BigDecimal.valueOf(amount), currency);
            accountManager.get(bank).addWithdrawableAccount(AccountEnum.SAVING, new SavingAccount(money, person));
        }

        return this;
    }

    public Money getResidueFromSavingAccount(BankEnum bank) {
        return accountManager.get(bank).getResidueFromSavingAccount(AccountEnum.SAVING);
    }

    public void printAccounts() {
        for (BankAccountManager bankManager : accountManager.values()) {
            System.out.println(bankManager.toString());
        }
    }

    public void substractSavingAccount(BankEnum bank, AbstractElement... elements) {
        for (AbstractElement element : elements) {
            element.setPrice(MoneyUtils.convertCurrency(element.price()));
            accountManager.get(bank).withdrawAmount(AccountEnum.SAVING, element);
        }
    }

    public boolean verifySavingAccountAmountToBuy(BankEnum bank, AbstractElement element) {
       /* Money totalAmount = new Money(BigDecimal.ZERO, "bs");
        for (BankAccountManager bankManager : accountManager.values()) {
            System.out.println(bankManager.toString());
            totalAmount.addAmount(bankManager.getResidueFromSavingAccount(AccountEnum.SAVING).getAmount());
        }*/

        Money totalAmount = this.getResidueFromSavingAccount(bank);

        return totalAmount.getAmount().compareTo(element.price().getAmount()) >= 0;
    }

    public Map<BankEnum, BankAccountManager> getAccountManager() {
        return accountManager;
    }
}
