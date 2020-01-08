package indexer.item.infrastructure.injector;

import shared.infrastructure.Injector.SharedInfrastructureInjector;
import indexer.item.infrastructure.persistence.SQLite.ItemRepositoryImpl;
import indexer.item.infrastructure.transformer.Matrix.ItemTransformerImpl;

final public class ItemInfrastructureInjector {

    public static ItemRepositoryImpl injectItemRepository() {
        return new ItemRepositoryImpl(
            SharedInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static ItemTransformerImpl injectItemTransformer() {
        return new ItemTransformerImpl(
            SharedInfrastructureInjector.injectMatrixService()
        );
    }
}
