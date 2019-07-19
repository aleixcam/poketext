package common.domain;

import java.util.List;

public interface SQLiteRepository {

    List<String[]> executeQuery(String query);
}
