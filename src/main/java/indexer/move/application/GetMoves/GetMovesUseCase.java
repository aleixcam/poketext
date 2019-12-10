package indexer.move.application.GetMoves;

import indexer.move.application.MoveTransformer;
import indexer.move.domain.*;

final public class GetMovesUseCase<T> {

    private MoveRepository repository;
    private MoveTransformer<T> transformer;

    public GetMovesUseCase(MoveRepository repository, MoveTransformer<T> transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public T execute(GetMovesRequest request) {
        MoveCriteria criteria = new MoveCriteria();
        criteria.setPokemonId(request.getPokemonId());
        criteria.setName(request.getName());
        criteria.setType(request.getType());

        MoveCollection moves = this.repository.findByCriteria(criteria);
        return this.transformer.transform(moves);
    }
}
