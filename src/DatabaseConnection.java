import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // Database URL
    private static final String URL =
            "jdbc:mysql://127.0.0.1:3307/student_management_system";

    // MySQL Username
    private static final String USER = "root";

    // MySQL Password is read from an environment variable
    private static final String PASSWORD =
            System.getenv("SMS_DB_PASSWORD");

    // Method to establish connection
    public static Connection getConnection() {

        if (PASSWORD == null || PASSWORD.isEmpty()) {

            System.out.println(
                    "❌ Database password is not configured."
            );

            return null;
        }

        try {

            Connection connection =
                    DriverManager.getConnection(URL, USER, PASSWORD);

            return connection;

        } catch (SQLException e) {

            System.out.println("❌ Connection failed!");
            e.printStackTrace();

            return null;
        }
    }
}