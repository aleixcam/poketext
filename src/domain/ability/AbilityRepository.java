package domain.ability;

public interface AbilityRepository {

    AbilitiesCollection findByCriteria(AbilityCriteria criteria);
}
