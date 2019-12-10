package indexer.ability.domain;

public interface AbilityRepository {

    AbilityCollection findByCriteria(AbilityCriteria criteria);
}
