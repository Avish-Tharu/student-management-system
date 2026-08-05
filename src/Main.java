import java.sql.Connection;

public class Main {

    public static void main(String[] args) {

        Connection connection = DatabaseConnection.getConnection();

        if (connection != null) {
            System.out.println("Database connection is working!");
        } else {
            System.out.println("Database connection failed!");
        }
    }
}