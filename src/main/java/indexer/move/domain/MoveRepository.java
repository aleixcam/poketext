package indexer.move.domain;

public interface MoveRepository {

    MoveCollection findByCriteria(MoveCriteria criteria);
}
