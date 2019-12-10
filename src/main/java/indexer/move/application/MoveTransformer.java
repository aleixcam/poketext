package indexer.move.application;

import indexer.move.domain.MoveCollection;

public interface MoveTransformer<T> {

    T transform(MoveCollection moves);
}
