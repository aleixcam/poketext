package domain.move;

import java.util.ArrayList;

public class MovesCollection {

    private ArrayList<Move> items = new ArrayList<>();

    public void add(Move move) {
        items.add(move);
    }

    public ArrayList<Move> moves() {
        return items;
    }
}
