package shared.pokemon.domain.Entity;

public final class BaseStats {

    private int health;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public BaseStats(
        int health,
        int attack,
        int defense,
        int specialAttack,
        int specialDefense,
        int speed
    ) {
        this.health = health;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public int health() {
        return health;
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
