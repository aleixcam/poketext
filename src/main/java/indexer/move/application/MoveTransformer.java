package indexer.move.application;

import indexer.move.domain.MovesCollection;

public interface MoveTransformer {

    String[][] assemble(MovesCollection moves);
}
