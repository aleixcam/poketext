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
}
