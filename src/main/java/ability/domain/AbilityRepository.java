package ability.domain;

public interface AbilityRepository {

    AbilitiesCollection findByCriteria(AbilityCriteria criteria);
}
