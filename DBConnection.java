import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
    public static Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:sqlite:users.db");
            Statement stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS users (" +
                         "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                         "name TEXT NOT NULL," +
                         "mobile TEXT NOT NULL," +
                         "gender TEXT," +
                         "dob TEXT," +
                         "address TEXT)";
            stmt.execute(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
        return conn;
    }
}
