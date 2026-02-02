package Controlers;
import Models.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import DAOs.StudentDAO;
@Controller
public class StudentController {
    private StudentDAO studentDAO = new StudentDAO();
    @GetMapping("/entry")
    public String showForm(Model model) {
        Student student = new Student();
        model.addAttribute("student",student);
        return "studentForm";
    }

    @PostMapping("/save")
    public String processForm(@ModelAttribute("student")Student student){
        if(student.getMarks()>50){
            student.setGrade("PASS");
        }else{
            student.setGrade("FAIL");
        }

        studentDAO.saveStudent(student);
        return "result";
    }

}
