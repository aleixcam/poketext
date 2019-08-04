package indexer.move.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import indexer.move.infrastructure.persistence.SQLite.MoveRepositoryImpl;
import indexer.move.infrastructure.transformer.Matrix.MoveTransformerImpl;

final public class MoveInfrastructureInjector {

    public static MoveRepositoryImpl injectMoveRepository() {
        return new MoveRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static MoveTransformerImpl injectMoveTransformer() {
        return new MoveTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
