package indexer.move.infrastructure.injector;

import indexer.move.application.GetMoves.GetMovesUseCase;

final public class MoveApplicationInjector {

    public static GetMovesUseCase<String[][]> injectGetMovesUseCase() {
        return new GetMovesUseCase<>(
            MoveInfrastructureInjector.SQLiteMoveRepository(),
            MoveInfrastructureInjector.matrixMoveTransformer()
        );
    }
}
