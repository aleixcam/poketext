package move.infrastructure.transformer.Matrix;

import common.domain.MatrixService;
import move.domain.Move;
import move.application.MoveTransformer;
import move.domain.MovesCollection;

import java.util.ArrayList;

final public class MoveTransformerImpl implements MoveTransformer {

    private final String[] COLUMNS = {"ID", "Name", "Type", "Class", "Pow", "Acc", "PP", "Effect"};

    private final MatrixService matrixService;

    public MoveTransformerImpl(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] assemble(MovesCollection collection) {
        ArrayList<Move> moves = collection.getMoves();
        String[][] matrix = matrixService.generate(COLUMNS, moves.size());

        for (int i = 0; i < moves.size(); i++) {
            matrix[i+1][0] = String.valueOf(moves.get(i).getId());
            matrix[i+1][1] = moves.get(i).getName();
            matrix[i+1][2] = moves.get(i).getType();
            matrix[i+1][3] = moves.get(i).getCategory();
            matrix[i+1][4] = String.valueOf(moves.get(i).getPower());
            matrix[i+1][5] = String.valueOf(moves.get(i).getAccuracy());
            matrix[i+1][6] = String.valueOf(moves.get(i).getPp());
            matrix[i+1][7] = moves.get(i).getEffect();
        }

        return matrixService.beautify(matrix);
    }
}
