package teambuilder.pokemon.domain.ValueObject;

public final class Happiness {

    private static final int MIN_HAPPINESS = 0;
    private static final int MAX_HAPPINESS = 255;

    private int value;

    public Happiness(int value) throws IllegalArgumentException {
        guardFromIllegalHappiness(value);
        this.value = value;
    }

    public int value() {
        return value;
    }

    private void guardFromIllegalHappiness(int value) throws IllegalArgumentException {
        if (value < MIN_HAPPINESS || value > MAX_HAPPINESS) {
            throw new IllegalArgumentException();
        }
    }
}
