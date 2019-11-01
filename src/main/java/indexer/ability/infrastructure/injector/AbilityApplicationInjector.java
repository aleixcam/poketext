package indexer.ability.infrastructure.injector;

import indexer.ability.application.GetAbilities.GetAbilitiesUseCase;

final public class AbilityApplicationInjector {

    public static GetAbilitiesUseCase<String[][]> injectGetAbilitiesUseCase() {
        return new GetAbilitiesUseCase<>(
            AbilityInfrastructureInjector.injectAbilityRepository(),
            AbilityInfrastructureInjector.injectAbilityTransformer()
        );
    }
}
