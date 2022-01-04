package element;

import money.Money;

public abstract class AbstractElement {
    private String name;
    private Money price;
    private Room typeRoom;

    public AbstractElement(Room typeRoom, String name, Money price) {
        this.name = name;
        this.price = price;
        this.typeRoom = typeRoom;
    }

    public Money price() {
        return price;
    }

    public void setPrice(Money price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Room getTypeRoom() {
        return typeRoom;
    }

    public void setTypeRoom(Room typeRoom) {
        this.typeRoom = typeRoom;
    }
}
