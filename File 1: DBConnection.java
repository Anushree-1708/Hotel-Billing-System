import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hoteldb",
                "root",
                "your_password"
            );
        } catch (Exception e) {
            System.out.println("Database Connection Failed!");
            return null;
        }
    }
}
