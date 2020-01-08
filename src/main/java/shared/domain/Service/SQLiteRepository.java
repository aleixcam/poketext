package shared.domain.Service;

import java.util.List;
import java.util.Map;

public interface SQLiteRepository {

    List<Map<String, Object>> executeQuery(String query);
}
