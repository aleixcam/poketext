package move.application;

import move.domain.MovesCollection;

public interface MoveTransformer {

    String[][] assemble(MovesCollection moves);
}
