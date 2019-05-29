package common.infrastructure.persistence;

import common.infrastructure.poketext.Connector;
import org.sqlite.JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteRepository {

    private Driver driver;
    private String database;
    private Connection connection;

    public SQLiteRepository() {
        this.driver = new JDBC();
        this.database = Connector.getDatabase();
    }

    private void openConnection() throws SQLException {
        DriverManager.registerDriver(driver);
        this.connection = DriverManager.getConnection(database);
    }

    private void closeConnection() throws SQLException {
        connection.close();
        DriverManager.deregisterDriver(driver);
    }

    private List<String[]> getTable(ResultSet results) throws SQLException {
        int columns = results.getMetaData().getColumnCount();
        List<String[]> table = new ArrayList<>();
        while(results.next()) {
            String[] row = new String[columns];
            for(int i = 1; i <= columns; i++)  {
                Object obj = results.getObject(i);
                row[i - 1] = (obj == null) ? null : obj.toString();
            }

            table.add(row);
        }

        return table;
    }

    public List<String[]> executeQuery(String query) {
        List<String[]> rowset = null;

        try {
            openConnection();
            rowset = getTable(connection.prepareStatement(query).executeQuery());
            closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return rowset;
    }
}