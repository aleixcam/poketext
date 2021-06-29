package indexer.move.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.move.infrastructure.persistence.SQLite.SQLiteMoveRepository;
import indexer.move.infrastructure.transformer.Matrix.MatrixMoveTransformer;

final public class MoveInfrastructureInjector {

    public static SQLiteMoveRepository SQLiteMoveRepository() {
        return new SQLiteMoveRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixMoveTransformer matrixMoveTransformer() {
        return new MatrixMoveTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
