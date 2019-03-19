package infrastructure.persistence.SQLite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class SQLiteRepository {

    private String url;

    SQLiteRepository() {
        this.url = "jdbc:sqlite:pokedex.sqlite";
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(this.url);
    }

    private void closeConnection(Connection connection) {
        try {
            connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(SQLiteRepository.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private List<String[]> getTable(ResultSet results) throws SQLException {
        int columns = results.getMetaData().getColumnCount();
        List<String[]> table = new ArrayList<>();
        while(results.next()) {
            String[] row = new String[columns];
            for( int i = 1; i <= columns; i++ ){
                Object obj = results.getObject( i );
                row[i-1] = (obj == null) ? null : obj.toString();
            }

            table.add(row);
        }

        return table;
    }

    protected List<String[]> executeQuery(String query) {
        List<String[]> rowset = null;

        try {
            Connection connection = getConnection();
            ResultSet results = connection.prepareStatement(query).executeQuery();
            rowset = getTable(results);
            closeConnection(connection);
        } catch (SQLException ex) {
            System.err.println(ex.getMessage());
        }

        return rowset;
    }

}
