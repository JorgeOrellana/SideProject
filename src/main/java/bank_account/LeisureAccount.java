package bank_account;

import money.Money;
import person.Person;

import java.math.BigDecimal;

public class LeisureAccount implements IWithdrawableAccount {

    private Money money;
    private Person person;

    public LeisureAccount(Money money, Person person) {
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
        this.money.subtractionAmount(amount.getAmount());
    }

}
