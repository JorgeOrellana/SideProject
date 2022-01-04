package person;

import bank_account.IAccount;

import java.util.List;

public class Person {
    private String name;
    private String lastName;
    private int ci;
    private List<IAccount> bankAccounts;

    public Person(String name, String lastName, int ci) {
        this.name = name;
        this.lastName = lastName;
        this.ci = ci;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getCi() {
        return ci;
    }

    public void setCi(int ci) {
        this.ci = ci;
    }
}
