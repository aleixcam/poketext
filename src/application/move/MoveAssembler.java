package application.move;

import domain.move.MovesCollection;

public interface MoveAssembler {

    String[][] assemble(MovesCollection moves);
}
