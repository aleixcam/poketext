package teambuilder.stat.domain;

import teambuilder.stat.domain.ValueObject.Stat;

public final class Stats {

    private static final int MAX_EVS = 508;

    private Stat healthPoints;
    private Stat attack;
    private Stat defense;
    private Stat specialAttack;
    private Stat specialDefense;
    private Stat speed;

    public Stat health() {
        return healthPoints;
    }

    public Stat attack() {
        return attack;
    }

    public Stat defense() {
        return defense;
    }

    public Stat specialAttack() {
        return specialAttack;
    }

    public Stat specialDefense() {
        return specialDefense;
    }

    public Stat speed() {
        return speed;
    }
}
