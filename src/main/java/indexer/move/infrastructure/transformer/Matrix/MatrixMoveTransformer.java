package indexer.move.infrastructure.transformer.Matrix;

import indexer.move.domain.Move;
import indexer.move.application.MoveTransformer;
import indexer.move.domain.MoveCollection;
import shared.core.infrastructure.Service.MatrixService;

import java.util.ArrayList;

final public class MatrixMoveTransformer implements MoveTransformer<String[][]> {

    private final String[] COLUMNS = {"ID", "Name", "Type", "Class", "Pow", "Acc", "PP", "Effect"};

    private final MatrixService matrixService;

    public MatrixMoveTransformer(MatrixService matrixService) {
        this.matrixService = matrixService;
    }

    public String[][] transform(MoveCollection collection) {
        ArrayList<Move> moves = collection.getMoves();
        String[][] matrix = matrixService.generate(COLUMNS, moves.size());

        for (int i = 0; i < moves.size(); i++) {
            matrix[i+1][0] = String.valueOf(moves.get(i).id());
            matrix[i+1][1] = moves.get(i).name();
            matrix[i+1][2] = moves.get(i).type();
            matrix[i+1][3] = moves.get(i).category();
            matrix[i+1][4] = String.valueOf(moves.get(i).power());
            matrix[i+1][5] = String.valueOf(moves.get(i).accuracy());
            matrix[i+1][6] = String.valueOf(moves.get(i).powerPoints());
            matrix[i+1][7] = moves.get(i).effect();
        }

        return matrixService.beautify(matrix);
    }
}
