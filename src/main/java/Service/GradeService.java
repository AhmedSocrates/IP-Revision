package Service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

@Service
public class GradeService {
    @PreAuthorize("hasRole('TEACHER')")
    public void assignGrade(String studentName, int marks) {
        // Logic to assign grade to the student
        String grade = (marks >= 50) ? "PASS" : "FAIL";
        System.out.println("Assigned grade " + grade + " to student " + studentName);
    }

    @PreAuthorize("hasAnyRole('TEACHER', 'ADMIN')")
    public String viewGrades(String studentName) {
        // Logic to view grades of the student
        // For demonstration, returning a dummy grade
        return "Student: " + studentName + ", Grade: PASS";
    }
}
