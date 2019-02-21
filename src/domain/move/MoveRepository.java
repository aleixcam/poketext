package domain.move;

import java.sql.SQLException;

public interface MoveRepository {

    MovesCollection findByCriteria(MoveCriteria criteria);
}
