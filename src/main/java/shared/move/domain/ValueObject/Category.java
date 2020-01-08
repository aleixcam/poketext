package shared.move.domain.ValueObject;

final public class Category {

    final int STATUS = 1;
    final int PHYSICAL = 2;
    final int SPECIAL = 3;

    private String value;

    public Category(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
