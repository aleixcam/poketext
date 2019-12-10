package shared.domain.Service;

import java.util.List;

public interface SQLiteRepository {

    List<String[]> executeQuery(String query);
}
