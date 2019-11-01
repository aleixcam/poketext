package indexer.move.application;

import indexer.move.domain.MovesCollection;

public interface MoveTransformer<T> {

    T transform(MovesCollection moves);
}
