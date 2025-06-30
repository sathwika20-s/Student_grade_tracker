# Student_grade_tracker@CodeAlpha
Step 1: Understanding the Project Structure
The project consists of three main classes:
1.	Student Class: Represents individual student data
2.	GradeTracker Class: Manages all students and operations
3.	StudentGradeTracker Class: Contains the main method
Step 2: Key Features Implemented
Core Requirements Met:
•	✅ Input and manage student grades
•	✅ Calculate average, highest, and lowest scores
•	✅ Uses ArrayList to store and manage data
•	✅ Display comprehensive summary reports
•	✅ Console-based interface
Additional Features:
•	Student ID system for unique identification
•	Letter grade calculation (A, B, C, D, F)
•	Class-wide statistics
•	Input validation and error handling
•	Student removal functionality
•	Detailed individual student reports
Step 3: How to Run the Project
1.	Save the code as StudentGradeTracker.java
2.	Compile: javac StudentGradeTracker.java
3.	Run: java StudentGradeTracker
Step 4: Usage Examples
Sample Test Data:
•	Add students: "John Doe" (ID: 001), "Jane Smith" (ID: 002)
•	Add grades for John: 85, 92, 78, 88
•	Add grades for Jane: 95, 87, 91, 93
Step 5: Code Architecture Explanation
Student Class Features:
java
- name, studentId, grades (ArrayList<Double>)
- addGrade(), getAverage(), getHighestGrade(), getLowestGrade()
- getLetterGrade() - converts average to letter grade
- Input validation for grades (0-100 range)
GradeTracker Class Features:
java
- ArrayList<Student> to store all students
- CRUD operations (Create, Read, Update, Delete)
- Statistical calculations
- User-friendly console interface
- Error handling and validation
Step 6: Customization Options
You can easily modify:
•	Grading Scale: Change the letter grade thresholds in getLetterGrade()
•	Grade Range: Modify validation in addGrade() method
•	Report Format: Customize the display methods
•	Additional Features: Add subjects, semesters, or GPA calculations
Step 7: Testing Your Application
Try these test scenarios:
1.	Add multiple students
2.	Add various grades (including edge cases like 0, 100)
3.	Test invalid inputs (negative grades, non-numeric input)
4.	Generate reports with different data sets
5.	Test removal functionality
Step 8: Potential Enhancements
For further development, consider adding:
•	File I/O to save/load data
•	GUI interface using JavaFX or Swing
•	Database integration
•	Grade categories (homework, exams, projects)
•	Export functionality (CSV, PDF)

