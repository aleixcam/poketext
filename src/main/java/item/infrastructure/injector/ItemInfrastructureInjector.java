package item.infrastructure.injector;

import shared.infrastructure.injector.SharedInfrastructureInjector;
import item.infrastructure.persistence.SQLite.ItemRepositoryImpl;
import item.infrastructure.transformer.Matrix.ItemTransformerImpl;

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
