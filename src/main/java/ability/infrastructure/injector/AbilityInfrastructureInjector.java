package ability.infrastructure.injector;

import ability.infrastructure.persistence.SQLite.AbilityRepositoryImpl;
import ability.infrastructure.transformer.Matrix.AbilityTransformerImpl;
import shared.infrastructure.injector.SharedInfrastructureInjector;

final public class AbilityInfrastructureInjector {

    public static AbilityRepositoryImpl injectAbilityRepository() {
        return new AbilityRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static AbilityTransformerImpl injectAbilityTransformer() {
        return new AbilityTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
