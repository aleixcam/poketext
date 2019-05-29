package move.application.GetMoves;

import move.application.MoveTransformer;
import move.domain.*;

public class GetMovesUseCase {

    private MoveRepository repository;
    private MoveTransformer assembler;

    public GetMovesUseCase(MoveRepository repository, MoveTransformer assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(int pokemon_id, String name, String type) {
        MoveCriteria criteria = new MoveCriteria();
        criteria.setPokemonId(pokemon_id);
        criteria.setName(name);
        criteria.setType(type);

        MovesCollection moves = this.repository.findByCriteria(criteria);
        return this.assembler.assemble(moves);
    }
}
