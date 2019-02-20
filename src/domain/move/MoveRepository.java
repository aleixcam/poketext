package domain.move;

import java.sql.SQLException;

public interface MoveRepository {

    String[][] findByCriteria(String pokemon_id, String name, String type) throws SQLException;
}
