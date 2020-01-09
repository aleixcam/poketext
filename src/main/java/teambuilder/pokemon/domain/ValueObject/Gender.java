package teambuilder.pokemon.domain.ValueObject;

public final class Gender {

    public static final int MALE_ONLY = 0;
    public static final int NORMALLY_MALE = 1;
    public static final int USUALLY_MALE = 2;
    public static final int EQUAL_CHANCE = 4;
    public static final int USUALLY_FEMALE = 6;
    public static final int NORMALLY_FEMALE = 7;
    public static final int FEMALE_ONLY = 8;
    public static final int GENDERLESS = -1;

    private int value;

    public Gender(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
