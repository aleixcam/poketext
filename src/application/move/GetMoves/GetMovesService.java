package application.move.GetMoves;

import domain.move.Move;
import domain.move.MoveCriteria;
import domain.move.MoveRepository;
import domain.move.MovesCollection;

import java.util.ArrayList;

public class GetMovesService {

    private MoveRepository repository;

    public GetMovesService(MoveRepository repository) {
        this.repository = repository;
    }

    public String[][] execute(int pokemon_id, String name, String type) {
        MoveCriteria criteria = new MoveCriteria();
        criteria.setPokemonId(pokemon_id);
        criteria.setName(name);
        criteria.setType(type);

        MovesCollection moves = this.repository.findByCriteria(criteria);

        return buildMatrix(moves);
    }

    private String[][] buildMatrix(MovesCollection moves) {
        ArrayList<Move> items = moves.moves();
        String[][] matrix = new String[items.size()][];
        for (int i = 0; i < items.size(); i++) {
            matrix[i][0] = items.get(i).getName();
            matrix[i][1] = items.get(i).getType();
            matrix[i][2] = items.get(i).getCategory();
            matrix[i][3] = String.valueOf(items.get(i).getPower());
            matrix[i][4] = String.valueOf(items.get(i).getAccuracy());
            matrix[i][5] = String.valueOf(items.get(i).getPowerPoints());
            matrix[i][6] = items.get(i).getEffect();
        }

        return matrix;
    }
}
