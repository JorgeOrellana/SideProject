import bank_account.*;
import element.AbstractElement;
import element.BedroomElement;
import element.HouseElementManager;
import element.KitchenroomElement;
import money.Money;
import person.Person;

import java.math.BigDecimal;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("***** Money Manager running... ******");

        Person person1 = new Person("Jose", "Perez", 12345);
        BankAccountManagerBuilder banks = new BankAccountManagerBuilder(person1)
                                            .addFixedAccount(BankEnum.BISA, 2800, "bs")
                                            .addSavingAccount(BankEnum.BISA, 3500, "bs");

        banks.printAccounts();

        System.out.println("************ Shopping *************");
        Money stovePrice = new Money(BigDecimal.valueOf(1000), "bs");
        AbstractElement stove = new KitchenroomElement("Stove", stovePrice);

        Money tvARS = new Money(BigDecimal.valueOf(8000), "ars");
        AbstractElement tvARSElement = new BedroomElement("TV", tvARS);

        Money coffeePrice = new Money(BigDecimal.valueOf(3000), "bs");
        AbstractElement cofee = new BedroomElement("Jala blend", coffeePrice);

        banks.substractSavingAccount(BankEnum.BISA, stove, tvARSElement, cofee);

        System.out.println("************ Residuo *************");

        banks.printAccounts();

        HouseElementManager allElements = new HouseElementManager("House");
        allElements.addElement(stove);
        allElements.addElement(tvARSElement);

        System.out.println("Total: " + allElements.price().getAmount());
    }
}
