package move.application.GetMoves;

import move.application.MoveTransformer;
import move.domain.*;

final public class GetMovesUseCase {

    private MoveRepository repository;
    private MoveTransformer assembler;

    public GetMovesUseCase(MoveRepository repository, MoveTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(GetMovesRequest request) {
        MoveCriteria criteria = new MoveCriteria();
        criteria.setPokemonId(request.getPokemonId());
        criteria.setName(request.getName());
        criteria.setType(request.getType());

        MovesCollection moves = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(moves);
    }
}
