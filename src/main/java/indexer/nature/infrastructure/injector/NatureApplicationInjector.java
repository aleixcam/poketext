package indexer.nature.infrastructure.injector;

import indexer.nature.application.GetNatures.GetNaturesUseCase;

public class NatureApplicationInjector {

    public static GetNaturesUseCase<String[][]> injectGetNaturesUseCase() {
        return new GetNaturesUseCase<>(
                NatureInfrastructureInjector.injectNatureRepository(),
                NatureInfrastructureInjector.injectNatureTransformer()
        );
    }
}
