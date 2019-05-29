package ability.application;

import ability.domain.AbilitiesCollection;

public interface AbilityTransformer {

    String[][] assemble(AbilitiesCollection items);
}
