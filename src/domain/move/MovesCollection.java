package domain.move;

import java.util.ArrayList;
import java.util.List;

public class MovesCollection {

    private ArrayList<Move> items = new ArrayList<Move>();

    public void add(Move move) {
        items.add(move);
    }

    public ArrayList<Move> moves() {
        return items;
    }

    public String[][] matrix() {
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
