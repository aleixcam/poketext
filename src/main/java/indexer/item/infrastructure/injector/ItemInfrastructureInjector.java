package indexer.item.infrastructure.injector;

import shared.core.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.item.infrastructure.persistence.SQLite.SQLiteItemRepository;
import indexer.item.infrastructure.transformer.Matrix.MatrixItemTransformer;

final public class ItemInfrastructureInjector {

    public static SQLiteItemRepository SQLiteItemRepository() {
        return new SQLiteItemRepository(
            SharedInfrastructureInjector.SQLiteManager()
        );
    }

    public static MatrixItemTransformer matrixItemTransformer() {
        return new MatrixItemTransformer(
            SharedInfrastructureInjector.matrixService()
        );
    }
}
