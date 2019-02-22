package domain.move;

public interface MoveRepository {

    MovesCollection findByCriteria(MoveCriteria criteria);
}
