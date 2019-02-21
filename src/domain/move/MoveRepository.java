package domain.move;

import java.sql.SQLException;
import java.util.ArrayList;

public interface MoveRepository {

    MovesCollection findByCriteria(String pokemon_id, String name, String type) throws SQLException;
}
