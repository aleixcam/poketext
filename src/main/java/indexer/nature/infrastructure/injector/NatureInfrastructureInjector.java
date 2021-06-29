package indexer.nature.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.nature.infrastructure.persistence.SQLite.SQLiteNatureRepository;
import indexer.nature.infrastructure.transformer.Matrix.MatrixNatureTransformer;

public class NatureInfrastructureInjector {

    public static SQLiteNatureRepository SQLiteNatureRepository() {
        return new SQLiteNatureRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixNatureTransformer matrixNatureTransformer() {
        return new MatrixNatureTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
