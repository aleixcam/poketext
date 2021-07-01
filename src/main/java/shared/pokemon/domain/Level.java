package shared.pokemon.domain;

public final class Level {

    private static final int MIN_LEVEL = 1;
    private static final int MAX_LEVEL = 100;

    private final int value;

    public Level(int value) throws IllegalArgumentException {
        guardFromIllegalLevel(value);
        this.value = value;
    }

    public int value() {
        return value;
    }

    private void guardFromIllegalLevel(int value) throws IllegalArgumentException {
        if (value < MIN_LEVEL || value > MAX_LEVEL) {
            throw new IllegalArgumentException();
        }
    }
}
