package ability.application;

import ability.application.GetAbilities.GetAbilitiesUseCase;
import ability.infrastructure.AbilityInfrastructureInjector;

final public class AbilityApplicationInjector {

    public static GetAbilitiesUseCase injectGetAbilitiesUseCase() {
        return new GetAbilitiesUseCase(
            AbilityInfrastructureInjector.injectAbilityRepository(),
            AbilityInfrastructureInjector.injectAbilityTransformer()
        );
    }
}
