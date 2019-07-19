package common.domain.service;

import java.util.List;

public interface SQLiteRepository {

    List<String[]> executeQuery(String query);
}
