package bank_account;

import money.Money;
import person.Person;

public class AbstractFixedAccount implements IAccount {
    
    private Money money;
    private Person person;

    public AbstractFixedAccount(Money money, Person person) {
        this.money = money;
        this.person = person;
    }

    @Override
    public void deposit(Money amount) {
        this.money.addAmount(amount.getAmount());
    }

    @Override
    public Money getResidue() {
        return money;
    }
}
