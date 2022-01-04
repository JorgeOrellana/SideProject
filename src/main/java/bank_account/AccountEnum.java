package bank_account;

public enum AccountEnum {
    SAVING("Saving", false),
    FIXED("Fixed", false),
    LEISURE("Leisure", false);

    private String name;
    private boolean fixed;

    AccountEnum(String name, boolean fixed) {
        this.name = name;
        this.fixed = fixed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }
}
