package bank_account;

import money.Money;

public interface IAccount {
    void deposit(Money amount);
    Money getResidue();
}
