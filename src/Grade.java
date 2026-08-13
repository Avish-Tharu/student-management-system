public class Grade {

    private int studentId;
    private String subject;
    private double marks;
    private String semester;
    private String grade;

    public Grade(
            int studentId,
            String subject,
            double marks,
            String semester,
            String grade) {

        this.studentId = studentId;
        this.subject = subject;
        this.marks = marks;
        this.semester = semester;
        this.grade = grade;
    }

    public int getStudentId() {
        return studentId;
    }

    public String getSubject() {
        return subject;
    }

    public double getMarks() {
        return marks;
    }

    public String getSemester() {
        return semester;
    }

    public String getGrade() {
        return grade;
    }
}
