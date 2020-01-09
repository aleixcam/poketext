package shared.move.domain;

import java.util.ArrayList;

public final class MoveCollection {

    private ArrayList<Move> moves = new ArrayList<>();

    public void add(Move move) {
        moves.add(move);
    }

    public ArrayList<Move> moves() {
        return moves;
    }
}

