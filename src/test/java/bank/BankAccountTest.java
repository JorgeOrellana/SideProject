package bank;

import bank_account.BankAccountManager;
import bank_account.BankAccountManagerBuilder;
import bank_account.BankAccountUtils;
import bank_account.BankEnum;
import element.AbstractElement;
import element.KitchenroomElement;
import money.Money;
import org.junit.Assert;
import org.junit.Test;
import person.Person;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BankAccountTest {

    @Test
    public void testWithdrawAmountFromSavingAccount() {
        Person person1 = new Person("Jose", "Perez", 12345);
        BankAccountManagerBuilder banks = new BankAccountManagerBuilder(person1)
                .addSavingAccount(BankEnum.BISA, 3500, "bs");
        Money stovePrice = new Money(BigDecimal.valueOf(1000), "bs");
        AbstractElement stove = new KitchenroomElement("Stove", stovePrice);
        Money expectedAmount = new Money(BigDecimal.valueOf(2500), "bs");

        banks.substractSavingAccount(BankEnum.BISA, stove);
        Money result = banks.getResidueFromSavingAccount(BankEnum.BISA);

        Assert.assertEquals(expectedAmount.getAmount().stripTrailingZeros(), result.getAmount().stripTrailingZeros());
    }

    @Test
    public void testVerifySavingAccountsAmountToBuy() {
        BankAccountManagerBuilder banks = mock(BankAccountManagerBuilder.class);
        when(banks.getResidueFromSavingAccount(BankEnum.ECONOMICO)).thenReturn(new Money(BigDecimal.valueOf(7000), "bs"));

        Money ps5Price = new Money(BigDecimal.valueOf(12000), "bs");
        AbstractElement ps5 = new KitchenroomElement("PS5", ps5Price);

        boolean res = BankAccountUtils.verifySavingAccountAmountToBuy(banks, BankEnum.ECONOMICO, ps5);
        Assert.assertFalse(res);
    }
}
