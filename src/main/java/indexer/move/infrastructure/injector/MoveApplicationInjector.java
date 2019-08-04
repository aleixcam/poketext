package indexer.move.infrastructure.injector;

import indexer.move.application.GetMoves.GetMovesUseCase;

final public class MoveApplicationInjector {

    public static GetMovesUseCase injectGetMovesUseCase() {
        return new GetMovesUseCase(
            MoveInfrastructureInjector.injectMoveRepository(),
            MoveInfrastructureInjector.injectMoveTransformer()
        );
    }
}
