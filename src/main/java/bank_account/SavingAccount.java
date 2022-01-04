package bank_account;

import money.Money;
import person.Person;

public class SavingAccount implements IWithdrawableAccount {

    private Money money;
    private Person person;

    public SavingAccount(Money money, Person person) {
        this.money = money;
        this.person = person;
    }

    @Override
    public void deposit(Money amount) {

    }

    @Override
    public Money getResidue() {
        return money;
    }

    @Override
    public void withdraw(Money amount) {
        money.subtractionAmount(amount.getAmount());
    }
}
