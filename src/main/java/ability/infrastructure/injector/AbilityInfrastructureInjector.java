package ability.infrastructure.injector;

import ability.infrastructure.persistence.SQLite.AbilityRepositoryImpl;
import ability.infrastructure.transformer.Matrix.AbilityTransformerImpl;
import shared.infrastructure.CommonInfrastructureInjector;

final public class AbilityInfrastructureInjector {

    public static AbilityRepositoryImpl injectAbilityRepository() {
        return new AbilityRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static AbilityTransformerImpl injectAbilityTransformer() {
        return new AbilityTransformerImpl(
            CommonInfrastructureInjector.injectMatrixService()
        );
    }
}
