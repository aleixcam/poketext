package shared.move.domain;

import shared.move.domain.Move;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public final class MoveCollection {

    public static final int MAX_SIZE = 4;

    private final ArrayList<Move> moves = new ArrayList<>();

    public void add(Move move) throws LimitExceededException {
        guardFromTooManyMoves();
        moves.add(move);
    }

    public ArrayList<Move> moves() {
        return moves;
    }

    private void guardFromTooManyMoves() throws LimitExceededException {
        if (moves.size() > MAX_SIZE) {
            throw new LimitExceededException();
        }
    }
}
