package shared.move.domain.ValueObject;

public enum Category {
    STATUS(1, "Status"),
    PHYSICAL(2, "Physical"),
    SPECIAL(3, "Special");

    private int id;
    private String value;

    Category(int id, String value) {
        this.id = id;
        this.value = value;
    }

    public int id() {
        return id;
    }

    public String value() {
        return value;
    }
}
