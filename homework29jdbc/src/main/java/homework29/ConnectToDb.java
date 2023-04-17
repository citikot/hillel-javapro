package homework29;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author spasko
 */
public class ConnectToDb {

    public static final String URL = "jdbc:mysql://localhost:3306/classicmodels";
    public static final String USER = "test";
    public static final String PASS = "test";

    private ConnectToDb() {
    }

    /**
     * Get a connection to database
     * 
     * @return Connection object
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
