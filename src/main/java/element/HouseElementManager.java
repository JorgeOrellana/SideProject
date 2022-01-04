package element;

import money.Money;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class HouseElementManager extends AbstractElement {
    //Composite
    private List<AbstractElement> elements;

    public HouseElementManager(String name) {
        super(null, name, null);
        elements = new ArrayList<>();
    }

    public void addElement(AbstractElement element) {
        this.elements.add(element);
    }

    public void removeElement(AbstractElement element) {
        this.elements.remove(element);
    }

    @Override
    public Money price() {
        Money total = new Money(BigDecimal.ZERO, "bs");
        for (AbstractElement element : elements) {
            total.addAmount(element.price().getAmount());
        }

        return total;
    }
}
