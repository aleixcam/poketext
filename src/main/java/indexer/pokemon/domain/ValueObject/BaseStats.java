package indexer.pokemon.domain.ValueObject;

public final class BaseStats {

    private final int healthPoints;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;

    public BaseStats(
        int healthPoints,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed
    ) {
        this.healthPoints = healthPoints;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public int healthPoints() {
        return healthPoints;
    }

    public int attack() {
        return attack;
    }

    public int defense() {
        return defense;
    }

    public int specialAttack() {
        return specialAttack;
    }

    public int specialDefense() {
        return specialDefense;
    }

    public int speed() {
        return speed;
    }
}
