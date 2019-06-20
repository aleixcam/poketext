package move.infrastructure.injector;

import move.application.GetMoves.GetMovesUseCase;

final public class MoveApplicationInjector {

    public static GetMovesUseCase injectGetMovesUseCase() {
        return new GetMovesUseCase(
            MoveInfrastructureInjector.injectMoveRepository(),
            MoveInfrastructureInjector.injectMoveTransformer()
        );
    }
}
