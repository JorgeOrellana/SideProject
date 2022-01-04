package bank_account;

import money.Money;

public interface IWithdrawableAccount extends IAccount {
    void withdraw(Money amount);
}
