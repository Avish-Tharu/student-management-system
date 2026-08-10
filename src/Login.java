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

showMainMenu();

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
public static void showMainMenu() {

    Scanner scanner = new Scanner(System.in);

    while (true) {

        System.out.println("\n=================================");
        System.out.println("            MAIN MENU");
        System.out.println("=================================");
        System.out.println("1. Add Student");
System.out.println("2. View Students");
System.out.println("3. Search Student");
System.out.println("4. Update Student");
System.out.println("5. Delete Student");
System.out.println("6. Course Management");
System.out.println("7. Logout");
        System.out.print("\nEnter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:
                addStudentMenu(scanner);
                break;

            case 2:
    ViewStudentService.viewStudents();
    break;
case 3:

    

    System.out.print("\nEnter Student ID: ");

    int studentId = scanner.nextInt();
    scanner.nextLine();

    SearchStudentService.searchStudent(studentId);

    break;
            
    

            case 4:

    System.out.print("\nEnter Student ID: ");
    int updateStudentId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("New Email: ");
    String email = scanner.nextLine();

    System.out.print("New Phone: ");
    String phone = scanner.nextLine();

    System.out.print("New Course ID: ");
    int courseId = scanner.nextInt();
    scanner.nextLine();

    UpdateStudentService.updateStudent(
           updateStudentId,
            email,
            phone,
            courseId
    );

    break;

            case 5:

    System.out.print("\nEnter Student ID: ");
    int deleteStudentId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Are you sure you want to delete this student? (Y/N): ");
    String confirmation = scanner.nextLine();

    if (confirmation.equalsIgnoreCase("Y")) {

        DeleteStudentService.deleteStudent(deleteStudentId);

    } else {

        System.out.println("\n❌ Delete cancelled.");
    }

    break;
    case 6:

    showCourseMenu(scanner);

    break;

            case 7:
    System.out.println("Logged out successfully.");
    return;

            default:
                System.out.println("Invalid choice!");
        }
    }
}
public static void addStudentMenu(Scanner scanner) {

    System.out.println("\n===== Add Student =====");

    System.out.print("First Name: ");
    String firstName = scanner.nextLine();

    System.out.print("Last Name: ");
    String lastName = scanner.nextLine();

    System.out.print("Email: ");
    String email = scanner.nextLine();

    System.out.print("Phone: ");
    String phone = scanner.nextLine();

    System.out.print("Date of Birth (YYYY-MM-DD): ");
    String dob = scanner.nextLine();

    System.out.print("Gender: ");
    String gender = scanner.nextLine();

    System.out.print("Course ID: ");
    int courseId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Enrollment Date (YYYY-MM-DD): ");
    String enrollmentDate = scanner.nextLine();

    Student student = new Student(
            firstName,
            lastName,
            email,
            phone,
            dob,
            gender,
            courseId,
            enrollmentDate
    );

    StudentService.addStudent(student);
}


// =================================
// COURSE MANAGEMENT
// =================================

public static void showCourseMenu(Scanner scanner) {

    while (true) {

        System.out.println("\n=================================");
        System.out.println("       COURSE MANAGEMENT");
        System.out.println("=================================");
        System.out.println("1. Add Course");
        System.out.println("2. View Courses");
        System.out.println("3. Search Course");
        System.out.println("4. Update Course");
        System.out.println("5. Delete Course");
        System.out.println("6. Back to Main Menu");

        System.out.print("\nEnter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        switch (choice) {

            case 1:

                System.out.println("\n===== Add Course =====");

                System.out.print("Course Name: ");
                String courseName = scanner.nextLine();

                System.out.print("Duration: ");
                String duration = scanner.nextLine();

                System.out.print("Fees: ");
                double fees = scanner.nextDouble();
                scanner.nextLine();

                Course course = new Course(
                        courseName,
                        duration,
                        fees
                );

                CourseService.addCourse(course);

                break;

            case 2:

                CourseService.viewCourses();

                break;

            case 3:

    System.out.print("\nEnter Course ID: ");

    int searchCourseId = scanner.nextInt();
    scanner.nextLine();

    SearchCourseService.searchCourse(searchCourseId);

    break;

            case 4:

    System.out.print("\nEnter Course ID: ");
    int updateCourseId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("New Course Name: ");
    String newCourseName = scanner.nextLine();

    System.out.print("New Duration: ");
    String newDuration = scanner.nextLine();

    System.out.print("New Fees: ");
    double newFees = scanner.nextDouble();
    scanner.nextLine();

    UpdateCourseService.updateCourse(
            updateCourseId,
            newCourseName,
            newDuration,
            newFees
    );

    break;
            case 5:

                System.out.println("Delete Course - Coming Soon");

                break;

            case 6:

                return;

            default:

                System.out.println("Invalid choice!");
        }
    }
}

}