import java.sql.*;
import java.util.Scanner;

public class Login {

    public static boolean login() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Student Management System");
        System.out.println("=================================");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        try {

            Connection conn = DatabaseConnection.getConnection();

            String sql = "SELECT * FROM users WHERE username=? AND password=?";

            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, username);
            pst.setString(2, password);

            ResultSet rs = pst.executeQuery();

            if (rs.next()) {

                System.out.println("\n✅ Login Successful!");
                System.out.println("Welcome " + username + "!");
                return true;

            } else {

                System.out.println("\n❌ Invalid Username or Password.");
                return false;

            }

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }

    }

}