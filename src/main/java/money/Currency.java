package money;

public interface Currency {
    void setNextChain(Currency nextChain);
    Money exchange(Money money);
}
