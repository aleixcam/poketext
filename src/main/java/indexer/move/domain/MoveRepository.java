package indexer.move.domain;

public interface MoveRepository {

    MovesCollection findByCriteria(MoveCriteria criteria);
}
