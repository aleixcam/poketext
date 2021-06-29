package showdown.pokemon.domain.ValueObject;

public final class Gender {

    private final char value;

    private Gender(char value) {
        this.value = value;
    }

    public static Gender male() {
        return new Gender('M');
    }

    public static Gender female() {
        return new Gender('F');
    }

    public static Gender random() {
        return new Gender('R');
    }

    public char value() {
        return this.value;
    }
}
