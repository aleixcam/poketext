package indexer.ability.domain;

public interface AbilityRepository {

    AbilitiesCollection findByCriteria(AbilityCriteria criteria);
}
