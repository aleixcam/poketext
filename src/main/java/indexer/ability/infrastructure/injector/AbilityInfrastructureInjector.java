package indexer.ability.infrastructure.injector;

import indexer.ability.infrastructure.persistence.SQLite.AbilityRepositoryImpl;
import indexer.ability.infrastructure.transformer.Matrix.AbilityTransformerImpl;
import shared.core.infrastructure.Injector.SharedInfrastructureInjector;

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
