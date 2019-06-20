package item.infrastructure;

import common.infrastructure.CommonInfrastructureInjector;
import item.infrastructure.persistence.SQLite.ItemRepositoryImpl;
import item.infrastructure.transformer.Matrix.ItemTransformerImpl;

final public class ItemInfrastructureInjector {

    public static ItemRepositoryImpl injectItemRepository() {
        return new ItemRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static ItemTransformerImpl injectItemTransformer() {
        return new ItemTransformerImpl();
    }
}
