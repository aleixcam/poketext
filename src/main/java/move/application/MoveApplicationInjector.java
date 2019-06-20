package move.application;

import move.application.GetMoves.GetMovesUseCase;
import move.infrastructure.MoveInfrastructureInjector;

final public class MoveApplicationInjector {

    public static GetMovesUseCase injectGetMovesUseCase() {
        return new GetMovesUseCase(
            MoveInfrastructureInjector.injectMoveRepository(),
            MoveInfrastructureInjector.injectMoveTransformer()
        );
    }
}
