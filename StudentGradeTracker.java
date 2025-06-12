import java.util.*;

// Student class to represent individual student data
class Student {
    private String name;
    private String studentId;
    private ArrayList<Double> grades;
    
    public Student(String name, String studentId) {
        this.name = name;
        this.studentId = studentId;
        this.grades = new ArrayList<>();
    }
    
    // Add a grade for the student
    public void addGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            grades.add(grade);
        } else {
            throw new IllegalArgumentException("Grade must be between 0 and 100");
        }
    }
    
    // Calculate average grade
    public double getAverage() {
        if (grades.isEmpty()) return 0.0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
    
    // Get highest grade
    public double getHighestGrade() {
        if (grades.isEmpty()) return 0.0;
        return Collections.max(grades);
    }
    
    // Get lowest grade
    public double getLowestGrade() {
        if (grades.isEmpty()) return 0.0;
        return Collections.min(grades);
    }
    
    // Get letter grade based on average
    public String getLetterGrade() {
        double avg = getAverage();
        if (avg >= 90) return "A";
        else if (avg >= 80) return "B";
        else if (avg >= 70) return "C";
        else if (avg >= 60) return "D";
        else return "F";
    }
    
    // Getters
    public String getName() { return name; }
    public String getStudentId() { return studentId; }
    public ArrayList<Double> getGrades() { return new ArrayList<>(grades); }
    public int getGradeCount() { return grades.size(); }
    
    // Setters
    public void setName(String name) { this.name = name; }
    
    @Override
    public String toString() {
        return String.format("ID: %s | Name: %s | Grades: %d | Average: %.2f | Letter: %s", 
                           studentId, name, grades.size(), getAverage(), getLetterGrade());
    }
}

// Main Grade Tracker class
class GradeTracker {
    private ArrayList<Student> students;
    private Scanner scanner;
    
    // Helper method to repeat characters (for Java versions before 11)
    private String repeatChar(char ch, int count) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(ch);
        }
        return sb.toString();
    }
    
    public GradeTracker() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }
    
    // Add a new student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine().trim();
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        
        // Check if student ID already exists
        if (findStudentById(id) != null) {
            System.out.println("Error: Student with ID " + id + " already exists!");
            return;
        }
        
        students.add(new Student(name, id));
        System.out.println("Student added successfully!");
    }
    
    // Find student by ID
    public Student findStudentById(String id) {
        for (Student student : students) {
            if (student.getStudentId().equals(id)) {
                return student;
            }
        }
        return null;
    }
    
    // Add grade to a student
    public void addGradeToStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found. Please add students first.");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        try {
            System.out.print("Enter grade (0-100): ");
            double grade = Double.parseDouble(scanner.nextLine().trim());
            student.addGrade(grade);
            System.out.println("Grade added successfully!");
        } catch (NumberFormatException e) {
            System.out.println("Invalid grade format! Please enter a number.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    // Display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.println("\n" + repeatChar('=', 80));
        System.out.println("                           STUDENT GRADE REPORT");
        System.out.println(repeatChar('=', 80));
        
        for (Student student : students) {
            System.out.println(student);
        }
        System.out.println(repeatChar('=', 80));
    }
    
    // Display detailed report for a specific student
    public void displayStudentDetails() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine().trim();
        
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.println("\n" + repeatChar('=', 50));
        System.out.println("           DETAILED STUDENT REPORT");
        System.out.println(repeatChar('=', 50));
        System.out.println("Student ID: " + student.getStudentId());
        System.out.println("Name: " + student.getName());
        System.out.println("Total Grades: " + student.getGradeCount());
        
        if (student.getGradeCount() > 0) {
            System.out.println("All Grades: " + student.getGrades());
            System.out.printf("Average: %.2f\n", student.getAverage());
            System.out.printf("Highest Grade: %.2f\n", student.getHighestGrade());
            System.out.printf("Lowest Grade: %.2f\n", student.getLowestGrade());
            System.out.println("Letter Grade: " + student.getLetterGrade());
        } else {
            System.out.println("No grades recorded for this student.");
        }
        System.out.println(repeatChar('=', 50));
    }
    
    // Display class statistics
    public void displayClassStatistics() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        double totalAverage = 0;
        double highestClassGrade = 0;
        double lowestClassGrade = 100;
        int totalGrades = 0;
        
        for (Student student : students) {
            if (student.getGradeCount() > 0) {
                totalAverage += student.getAverage();
                totalGrades++;
                
                if (student.getHighestGrade() > highestClassGrade) {
                    highestClassGrade = student.getHighestGrade();
                }
                
                if (student.getLowestGrade() < lowestClassGrade) {
                    lowestClassGrade = student.getLowestGrade();
                }
            }
        }
        
        System.out.println("\n" + repeatChar('=', 50));
        System.out.println("             CLASS STATISTICS");
        System.out.println(repeatChar('=', 50));
        System.out.println("Total Students: " + students.size());
        System.out.println("Students with Grades: " + totalGrades);
        
        if (totalGrades > 0) {
            System.out.printf("Class Average: %.2f\n", totalAverage / totalGrades);
            System.out.printf("Highest Grade in Class: %.2f\n", highestClassGrade);
            System.out.printf("Lowest Grade in Class: %.2f\n", lowestClassGrade);
        } else {
            System.out.println("No grades recorded yet.");
        }
        System.out.println(repeatChar('=', 50));
    }
    
    // Remove a student
    public void removeStudent() {
        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }
        
        System.out.print("Enter student ID to remove: ");
        String id = scanner.nextLine().trim();
        
        Student student = findStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        
        System.out.printf("Are you sure you want to remove %s? (y/n): ", student.getName());
        String confirm = scanner.nextLine().trim().toLowerCase();
        
        if (confirm.equals("y") || confirm.equals("yes")) {
            students.remove(student);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Operation cancelled.");
        }
    }
    
    // Main menu
    public void displayMenu() {
        System.out.println("\n" + repeatChar('=', 50));
        System.out.println("         STUDENT GRADE TRACKER");
        System.out.println(repeatChar('=', 50));
        System.out.println("1. Add New Student");
        System.out.println("2. Add Grade to Student");
        System.out.println("3. View All Students");
        System.out.println("4. View Student Details");
        System.out.println("5. View Class Statistics");
        System.out.println("6. Remove Student");
        System.out.println("7. Exit");
        System.out.println(repeatChar('=', 50));
        System.out.print("Enter your choice (1-7): ");
    }
    
    // Main program loop
    public void run() {
        System.out.println("Welcome to Student Grade Tracker!");
        
        while (true) {
            displayMenu();
            
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
                
                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        addGradeToStudent();
                        break;
                    case 3:
                        displayAllStudents();
                        break;
                    case 4:
                        displayStudentDetails();
                        break;
                    case 5:
                        displayClassStatistics();
                        break;
                    case 6:
                        removeStudent();
                        break;
                    case 7:
                        System.out.println("Thank you for using Student Grade Tracker!");
                        return;
                    default:
                        System.out.println("Invalid choice! Please enter a number between 1-7.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Please enter a number.");
            }
            
            // Pause before showing menu again
            System.out.println("\nPress Enter to continue...");
            scanner.nextLine();
        }
    }
}

// Main class
public class StudentGradeTracker {
    public static void main(String[] args) {
        GradeTracker tracker = new GradeTracker();
        tracker.run();
    }
}