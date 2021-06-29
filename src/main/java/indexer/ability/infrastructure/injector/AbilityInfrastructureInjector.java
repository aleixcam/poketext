package indexer.ability.infrastructure.injector;

import indexer.ability.infrastructure.persistence.SQLite.SQLiteAbilityRepository;
import indexer.ability.infrastructure.transformer.Matrix.MatrixAbilityTransformer;
import shared.core.infrastructure.Injector.SharedInfrastructureInjector;

final public class AbilityInfrastructureInjector {

    public static SQLiteAbilityRepository SQLiteAbilityRepository() {
        return new SQLiteAbilityRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixAbilityTransformer matrixAbilityTransformer() {
        return new MatrixAbilityTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
