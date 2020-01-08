package teambuilder.pokemon.domain.ValueObject;

final public class Gender {

    final int MALE_ONLY = 0;
    final int NORMALLY_MALE = 1;
    final int USUALLY_MALE = 2;
    final int EQUAL_CHANCE = 4;
    final int USUALLY_FEMALE = 6;
    final int NORMALLY_FEMALE = 7;
    final int FEMALE_ONLY = 8;
    final int GENDERLESS = -1;

    private int value;

    public Gender(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}
