package shared.core.infrastructure.Persistence.SQLite;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SQLiteManager {

    private final Driver driver;
    private final String database;
    private Connection connection;

    public SQLiteManager(Driver driver, String database) {
        this.driver = driver;
        this.database = database;
    }

    public List<Map<String, Object>> executeQuery(String query) {
        List<Map<String, Object>> list = null;

        try {
            openConnection();
            list = getTable(connection.prepareStatement(query).executeQuery());
            closeConnection();
        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return list;
    }

    private void openConnection() throws SQLException {
        DriverManager.registerDriver(driver);
        this.connection = DriverManager.getConnection(database);
    }

    private void closeConnection() throws SQLException {
        connection.close();
        DriverManager.deregisterDriver(driver);
    }

    private List<Map<String, Object>> getTable(ResultSet results) throws SQLException {
        ResultSetMetaData metadata = results.getMetaData();
        List<Map<String, Object>> table = new ArrayList<>();
        while(results.next()) {
            Map<String, Object> row = new HashMap<>();
            for(int i = 1; i <= metadata.getColumnCount(); i++)  {
                row.put(metadata.getColumnName(i), results.getObject(i));
            }

            table.add(row);
        }

        return table;
    }
}
