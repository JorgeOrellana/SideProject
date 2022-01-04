package bank_account;

public enum BankEnum {

    BISA(1, "Bisa"),
    ECONOMICO(2, "Economico");

    private int code;
    private String name;

    BankEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }
}
