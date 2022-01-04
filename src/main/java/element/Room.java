package element;

public enum Room {

    KITCHENROOM(1, "Kitchenroom"),
    WASHINGROOM(2, "Washing_room"),
    BEDROOM(3, "Bedroom")
    ;

    private int code;
    private String roomName;

    Room(int code, String roomName) {
        this.code = code;
        this.roomName = roomName;
    }
}
