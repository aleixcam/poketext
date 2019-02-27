package application.move;

import domain.move.*;

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
        return this.assembler.assemble(moves);
    }
}
