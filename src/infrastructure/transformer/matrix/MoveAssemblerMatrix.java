package infrastructure.transformer.matrix;

import domain.move.Move;
import domain.move.MoveAssembler;
import domain.move.MovesCollection;

import java.util.ArrayList;

public class MoveAssemblerMatrix extends MatrixAssembler implements MoveAssembler {

    public String[][] assemble(MovesCollection moves) {
        ArrayList<Move> items = moves.moves();
        String[] columns = {"ID", "Name", "Type", "Class", "Pow", "Acc", "PP", "Effect"};
        String[][] matrix = new String[items.size() + 1][columns.length];

        matrix[0] = columns;
        for (int i = 0; i < items.size(); i++) {
            matrix[i+1][0] = String.valueOf(items.get(i).getId());
            matrix[i+1][1] = items.get(i).getName();
            matrix[i+1][2] = items.get(i).getType();
            matrix[i+1][3] = items.get(i).getCategory();
            matrix[i+1][4] = String.valueOf(items.get(i).getPower());
            matrix[i+1][5] = String.valueOf(items.get(i).getAccuracy());
            matrix[i+1][6] = String.valueOf(items.get(i).getPp());
            matrix[i+1][7] = items.get(i).getEffect();
        }

        return generate(matrix);
    }
}
