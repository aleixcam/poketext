package indexer.ability.application;

import indexer.ability.domain.AbilitiesCollection;

public interface AbilityTransformer {

    String[][] assemble(AbilitiesCollection items);
}
