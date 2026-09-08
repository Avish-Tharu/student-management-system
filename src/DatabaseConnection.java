import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3307/student_management_system";

    // MySQL Username
    private static final String USER = "root";

    // MySQL Password
    private static final String PASSWORD = "10201209";

    // Establish database connection
    public static Connection getConnection() {

        try {

            return DriverManager.getConnection(
                    URL,
                    USER,
                    PASSWORD
            );

        } catch (SQLException e) {

            System.out.println(
                    "❌ Unable to connect to the database."
            );

            System.out.println(
                    "Please check that MySQL is running."
            );

            return null;
        }
    }
}