package application.move.GetMoves;

import domain.move.*;

import java.util.ArrayList;

public class GetMovesService {

    private MoveRepository repository;
    private MoveAssembler assembler;

    public GetMovesService(MoveRepository repository, MoveAssembler assembler) {
        this.repository = repository;
        this.assembler = assembler;
    }

    public String[][] execute(int pokemon_id, String name, String type) {
        MoveCriteria criteria = new MoveCriteria();
        criteria.setPokemonId(pokemon_id);
        criteria.setName(name);
        criteria.setType(type);

        MovesCollection moves = this.repository.findByCriteria(criteria);
        ArrayList<Move> asdf = moves.moves();
        return this.assembler.assemble(moves);
    }
}
