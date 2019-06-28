package nature.infrastructure.injector;

import nature.application.GetNatures.GetNaturesUseCase;

public class NatureApplicationInjector {

    public static GetNaturesUseCase injectGetNaturesUseCase() {
        return new GetNaturesUseCase(
                NatureInfrastructureInjector.injectNatureRepository(),
                NatureInfrastructureInjector.injectNatureTransformer()
        );
    }
}
