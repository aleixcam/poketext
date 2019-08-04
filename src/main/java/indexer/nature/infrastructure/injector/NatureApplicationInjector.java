package indexer.nature.infrastructure.injector;

import indexer.nature.application.GetNatures.GetNaturesUseCase;

public class NatureApplicationInjector {

    public static GetNaturesUseCase injectGetNaturesUseCase() {
        return new GetNaturesUseCase(
                NatureInfrastructureInjector.injectNatureRepository(),
                NatureInfrastructureInjector.injectNatureTransformer()
        );
    }
}
