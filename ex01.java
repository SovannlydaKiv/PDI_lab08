public class ex01 {
    public static void main(String[] args) {
        Student stu = new Student ("Lyda", 90, "lyda@gmail.com");
        GradeCalculator gradeCalc = new GradeCalculator();
        StudentRepository repo = new StudentRepository();
        EmailService email = new EmailService();

        String grade = gradeCalc.calculateGrade(stu.getMarks());
        System.out.println("Grade for " + stu.getName() + ": " + grade);
        repo.saveToDatabase(stu);
        email.sendResultEmail(stu, grade);
        System.out.println();
    }
}
class Student {
    String name;
    int marks;
    String email;
    String studentId;
    int age;
    String major;
    
    public Student(String name, int marks, String email) {
        this.name = name;
        this.marks = marks;
        this.email = email;
    }
    
    String getName() { return name; }
    int getMarks() { return marks; }
    String getEmail() { return email; }
}

class GradeCalculator {
    String gradeScale;
    int passingMarks;
    boolean useGradePoints;
    
    public GradeCalculator() {
        this.passingMarks = 40;
    }
    
    String calculateGrade(int marks) {
        if (marks >= 90) return "A";
        if (marks >= 75) return "B";
        if (marks >= 60) return "C";
        if (marks >= 40) return "D";
        return "F";
    }
    
    boolean isPassing(int marks) {
        return marks >= passingMarks;
    }
    
    double getGradePoint(String grade) {
        switch(grade) {
            case "A": return 4.0;
            case "B": return 3.0;
            case "C": return 2.0;
            default: return 0.0;
        }
    }
}

class StudentRepository {
    String databaseName;
    String connectionString;
    int recordCount;
    
    void saveToDatabase(Student student) {
        System.out.println("Saving " + student.getName() + " to database");
    }
    
    Student loadFromDatabase(String studentId) {
        System.out.println("Loading student: " + studentId);
        return null;
    }
    
    void deleteFromDatabase(String studentId) {
        System.out.println("Deleting student: " + studentId);
    }
}

class EmailService {
    String smtpServer;
    String senderEmail;
    int emailsSent;
    
    void sendResultEmail(Student student, String grade) {
        System.out.println("Sending email to " + student.getEmail() + " with grade: " + grade);
    }
    
    void sendWelcomeEmail(Student student) {
        System.out.println("Sending welcome email to " + student.getEmail());
    }
    
    void sendReminderEmail(Student student) {
        System.out.println("Sending reminder to " + student.getEmail());
    }
}
