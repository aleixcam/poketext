package shared.move.domain.ValueObject;

public enum Category {
    STATUS("Status"),
    PHYSICAL("Physical"),
    SPECIAL("Special");

    private String value;

    Category(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
