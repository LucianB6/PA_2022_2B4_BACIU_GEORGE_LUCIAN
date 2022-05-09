import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Database {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String USER = "postgres";
    private static final String PASSWORD = "Liceualecsandri1";
    private static Connection connection = null;
    private static Statement statement = null;

    private Database() {}
    public static Connection getConnection() {
        createConnection();
        return connection;
    }
    private static void createConnection(){
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            //connection.setAutoCommit(false);
            statement = connection.createStatement();

          } catch (SQLException e) {
            System.err.println(e);
        }
    }
    public static void rollback() {
    }
}
