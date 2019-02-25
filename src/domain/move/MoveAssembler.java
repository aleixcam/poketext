package domain.move;

import domain.move.MovesCollection;

import java.util.ArrayList;

public interface MoveAssembler {

    String[][] assemble(MovesCollection moves);
}
