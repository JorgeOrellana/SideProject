package bank_account;

import element.AbstractElement;
import money.Money;
import person.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankAccountManager {

    private Person person;
    private BankEnum bank;
    private String currency;
    private Map<AccountEnum, AbstractFixedAccount> fixedAccounts;
    private Map<AccountEnum, IWithdrawableAccount> withdrawableAccounts;

    public BankAccountManager(BankEnum bank, Person person, String currency) {
        this.person = person;
        this.bank = bank;
        this.currency = currency;
        this.fixedAccounts = new HashMap<>();
        this.withdrawableAccounts = new HashMap<>();
    }

    public void addFixedAccount(AccountEnum account, AbstractFixedAccount fixedAccount) {
        this.fixedAccounts.put(account, fixedAccount);
    }

    public void addWithdrawableAccount(AccountEnum account, IWithdrawableAccount withdrawableAccount) {
        this.withdrawableAccounts.put(account, withdrawableAccount);
    }

    public void withdrawAmount(AccountEnum account, AbstractElement element) {
        IWithdrawableAccount withdrawAccount = withdrawableAccounts.get(account);
        if (withdrawAccount != null && withdrawAccount.getResidue().getAmount().compareTo(element.price().getAmount()) > 0) {
            withdrawableAccounts.get(account).withdraw(element.price());
            System.out.println("Buying... " + element.getName() + " - " + element.price().getAmount() + " " + element.price().getCurrency());
        } else {
            System.out.println("No enough money  to buy " + element.getName());
        }
    }

    public Money getResidueFromSavingAccount(AccountEnum account) {
        return withdrawableAccounts.get(account).getResidue();
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder()
        .append("Person: " + person.getName() + "\n")
        .append("Bank: " + bank.name() + "\n");

        fixedAccounts.entrySet().stream().forEach(account -> result.append( "Account " + account.getKey().getName() +" - " + account.getValue().getResidue().getAmount() + "\n"));
        withdrawableAccounts.entrySet().stream().forEach(account -> result.append( "Account " + account.getKey().getName() +" - " + account.getValue().getResidue().getAmount() + "\n"));

        return result.toString();
    }
}
