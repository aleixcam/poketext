package shared.move.domain.ValueObject;

public final class Category {

    public static final int STATUS = 1;
    public static final int PHYSICAL = 2;
    public static final int SPECIAL = 3;

    private String value;

    public Category(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
