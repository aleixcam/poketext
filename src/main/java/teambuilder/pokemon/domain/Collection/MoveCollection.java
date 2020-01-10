package teambuilder.pokemon.domain.Collection;

import shared.move.domain.Move;

import javax.naming.LimitExceededException;
import java.util.ArrayList;

public final class MoveCollection {

    public static final int MAX_SIZE = 4;

    private ArrayList<Move> moves = new ArrayList<>();

    public void add(Move pokemon) throws LimitExceededException {
        guardFromTooManyPokemons();
        moves.add(pokemon);
    }

    public ArrayList<Move> moves() {
        return moves;
    }

    private void guardFromTooManyPokemons() throws LimitExceededException {
        if (moves.size() > MAX_SIZE) {
            throw new LimitExceededException();
        }
    }
}
