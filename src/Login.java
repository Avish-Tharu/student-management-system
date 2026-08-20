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

    String role = rs.getString("role");

    System.out.println("\n✅ Login Successful!");
    System.out.println("Welcome " + username + "!");
    System.out.println("Role: " + role);

    showMainMenu(role);

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
public static void showMainMenu(String role) {

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
System.out.println("7. Grade Management");

if (role.equalsIgnoreCase("ADMIN")) {
    System.out.println("8. Admin Dashboard");
    System.out.println("9. Logout");
} else {
    System.out.println("8. Logout");
}
        

        int choice = InputHelper.readInt(
        scanner,
        "\nEnter your choice: "
);

        switch (choice) {

            case 1:
                addStudentMenu(scanner);
                break;

            case 2:
    ViewStudentService.viewStudents();
    break;
case 3:

    

    int studentId = InputHelper.readInt(
        scanner,
        "\nEnter Student ID: "
);

    SearchStudentService.searchStudent(studentId);

    break;
            
    

            case 4:

    int updateStudentId = InputHelper.readInt(
        scanner,
        "\nEnter Student ID: "
);

    String email;

while (true) {

    System.out.print("Email: ");
    email = scanner.nextLine().trim();

    if (!InputValidator.isValidEmail(email)) {

        System.out.println("❌ Invalid email format. Please try again.");

    } else {

        break;
    }
}
String phone;

while (true) {

    System.out.print("Phone: ");
    phone = scanner.nextLine().trim();

    if (!InputValidator.isValidPhone(phone)) {

        System.out.println(
                "❌ Invalid phone number. Enter exactly 10 digits."
        );

    } else {

        break;
    }
}

    int courseId = InputHelper.readInt(
        scanner,
        "Enter Course ID: "
);

    UpdateStudentService.updateStudent(
           updateStudentId,
            email,
            phone,
            courseId
    );

    break;

            case 5:

    int deleteStudentId = InputHelper.readInt(
        scanner,
        "\nEnter Student ID: "
);

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

    showGradeMenu(scanner);

    break;

case 8:

    if (role.equalsIgnoreCase("ADMIN")) {

        DashboardService.showDashboard();

    } else {

        System.out.println("Logged out successfully.");
        return;
    }

    break;

case 9:

    if (role.equalsIgnoreCase("ADMIN")) {

        System.out.println("Logged out successfully.");
        return;

    } else {

        System.out.println("Invalid choice!");
    }

    break;

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

    String dob;

while (true) {

    System.out.print("Date of Birth (YYYY-MM-DD): ");
    dob = scanner.nextLine().trim();

    if (!InputValidator.isValidDate(dob)) {

        System.out.println(
                "❌ Invalid date. Please use YYYY-MM-DD."
        );

    } else {

        break;
    }
}

    System.out.print("Gender: ");
    String gender = scanner.nextLine();

    int courseId = InputHelper.readInt(
        scanner,
        "Course ID: "
);
    String enrollmentDate;

while (true) {

    System.out.print("Enrollment Date (YYYY-MM-DD): ");
    enrollmentDate = scanner.nextLine().trim();

    if (!InputValidator.isValidDate(enrollmentDate)) {

        System.out.println(
                "❌ Invalid date. Please use YYYY-MM-DD."
        );

    } else {

        break;
    }
}

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

        int choice = InputHelper.readInt(
        scanner,
        "\nEnter your choice: "
);

        switch (choice) {

            case 1:

                System.out.println("\n===== Add Course =====");

                String courseName;

while (true) {

    System.out.print("Course Name: ");
    courseName = scanner.nextLine().trim();

    if (!InputValidator.isNotEmpty(courseName)) {

        System.out.println("❌ Course name cannot be empty.");

    } else {

        break;
    }
}
String duration;

while (true) {

    System.out.print("Duration: ");
    duration = scanner.nextLine().trim();

    if (!InputValidator.isNotEmpty(duration)) {

        System.out.println("❌ Duration cannot be empty.");

    } else {

        break;
    }
}
double fees;

while (true) {

    System.out.print("Fees: ");

    try {

        fees = scanner.nextDouble();
        scanner.nextLine();

        if (!InputValidator.isValidFees(fees)) {

            System.out.println("❌ Fees cannot be negative.");

        } else {

            break;
        }

    } catch (Exception e) {

        System.out.println("❌ Please enter a valid number.");

        scanner.nextLine();
    }
}

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

    int searchCourseId = InputHelper.readInt(
        scanner,
        "\nEnter Course ID: "
);
    SearchCourseService.searchCourse(searchCourseId);

    break;

            case 4:

    int updateCourseId = InputHelper.readInt(
        scanner,
        "\nEnter Course ID: "
);
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

    int deleteCourseId = InputHelper.readInt(
        scanner,
        "\nEnter Course ID: "
);

    System.out.print(
            "Are you sure you want to delete this course? (Y/N): "
    );

    String confirmation = scanner.nextLine();

    if (confirmation.equalsIgnoreCase("Y")) {

        DeleteCourseService.deleteCourse(deleteCourseId);

    } else {

        System.out.println("\n❌ Delete cancelled.");
    }

    break;

            case 6:

                return;

            default:

                System.out.println("Invalid choice!");
        }
    }
}
// =================================
// GRADE MANAGEMENT
// =================================

public static void showGradeMenu(Scanner scanner) {

    while (true) {

        System.out.println("\n=================================");
        System.out.println("        GRADE MANAGEMENT");
        System.out.println("=================================");
        System.out.println("1. Add Grade");
        System.out.println("2. View Grades");
        System.out.println("3. Search Grade");
        System.out.println("4. Update Grade");
        System.out.println("5. Delete Grade");
        System.out.println("6. Back to Main Menu");

        int choice = InputHelper.readInt(
        scanner,
        "\nEnter your choice: "
);
        switch (choice) {

            case 1:

                System.out.println("\n===== Add Grade =====");

                int studentId = InputHelper.readInt(
        scanner,
        "Student ID: "
);
                System.out.print("Subject: ");
                String subject = scanner.nextLine();

                double marks;

while (true) {

    System.out.print("Marks: ");

    try {

        marks = scanner.nextDouble();
        scanner.nextLine();

        if (!InputValidator.isValidMarks(marks)) {

            System.out.println(
                    "❌ Marks must be between 0 and 100."
            );

        } else {

            break;
        }

    } catch (Exception e) {

        System.out.println("❌ Please enter a valid number.");

        scanner.nextLine();
    }
}

                String semester;

while (true) {

    System.out.print("Semester: ");
    semester = scanner.nextLine().trim();

    if (!InputValidator.isNotEmpty(semester)) {

        System.out.println("❌ Semester cannot be empty.");

    } else {

        break;
    }
}


                String gradeValue;

while (true) {

    System.out.print("Grade: ");
    gradeValue = scanner.nextLine().trim();

    if (!InputValidator.isNotEmpty(gradeValue)) {

        System.out.println("❌ Grade cannot be empty.");

    } else {

        break;
    }
}

Grade grade = new Grade(
        studentId,
        subject,
        marks,
        semester,
        gradeValue
);
                GradeService.addGrade(grade);

                break;

            case 2:

    ViewGradeService.viewGrades();

    break;

            case 3:

    System.out.print("\nEnter Grade ID: ");

    int searchGradeId = scanner.nextInt();
    scanner.nextLine();

    SearchGradeService.searchGrade(searchGradeId);

    break;

            case 4:

    System.out.print("\nEnter Grade ID: ");
    int updateGradeId = scanner.nextInt();
    scanner.nextLine();

    System.out.print("New Marks: ");
    double newMarks = scanner.nextDouble();
    scanner.nextLine();

    System.out.print("New Semester: ");
    String newSemester = scanner.nextLine();

    System.out.print("New Grade: ");
    String newGrade = scanner.nextLine();

    UpdateGradeService.updateGrade(
            updateGradeId,
            newMarks,
            newSemester,
            newGrade
    );

    break;

            case 5:

    System.out.print("\nEnter Grade ID: ");

    int deleteGradeId = scanner.nextInt();
    scanner.nextLine();

    System.out.print(
            "Are you sure you want to delete this grade? (Y/N): "
    );

    String confirmation = scanner.nextLine();

    if (confirmation.equalsIgnoreCase("Y")) {

        DeleteGradeService.deleteGrade(deleteGradeId);

    } else {

        System.out.println("\n❌ Delete cancelled.");
    }

    break;

            case 6:

                return;

            default:

                System.out.println("Invalid choice!");
        }
    }
}
}

