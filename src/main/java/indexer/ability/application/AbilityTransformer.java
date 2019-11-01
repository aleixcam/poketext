package indexer.ability.application;

import indexer.ability.domain.AbilitiesCollection;

public interface AbilityTransformer<T> {

    T transform(AbilitiesCollection items);
}
