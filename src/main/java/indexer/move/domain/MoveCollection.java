package indexer.move.domain;

import java.util.ArrayList;

public class MoveCollection {

    private ArrayList<Move> moves = new ArrayList<>();

    public void add(Move move) {
        moves.add(move);
    }

    public ArrayList<Move> getMoves() {
        return moves;
    }
}
