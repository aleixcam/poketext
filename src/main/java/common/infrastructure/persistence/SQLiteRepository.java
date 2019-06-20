package common.infrastructure.persistence;

import java.util.List;

public interface SQLiteRepository {

    List<String[]> executeQuery(String query);
}
