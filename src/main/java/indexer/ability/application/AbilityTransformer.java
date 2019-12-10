package indexer.ability.application;

import indexer.ability.domain.AbilityCollection;

public interface AbilityTransformer<T> {

    T transform(AbilityCollection items);
}
