package nature.infrastructure.injector;

import common.infrastructure.CommonInfrastructureInjector;
import nature.infrastructure.persistence.SQLite.NatureRepositoryImpl;
import nature.infrastructure.transformer.Matrix.NatureTransformerImpl;

public class NatureInfrastructureInjector {

    public static NatureRepositoryImpl injectNatureRepository() {
        return new NatureRepositoryImpl(
            CommonInfrastructureInjector.injectSQLiteRepository()
        );
    }

    public static NatureTransformerImpl injectNatureTransformer() {
        return new NatureTransformerImpl();
    }
}
