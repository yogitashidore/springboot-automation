// StudentController.java
package net.shadervertex.sms.controller;

import jakarta.validation.Valid;
import net.shadervertex.sms.entity.Student;
import net.shadervertex.sms.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public String listStudents(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    
    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") Student student, BindingResult result) {
        // Check if the first name is empty or null
        if (student.getFirstName() == null || student.getFirstName().isEmpty()) {
            // Add a field error for the first name
            result.rejectValue("firstName", "NotEmpty", "First name must not be empty");
            // Return an error response
            return "create_student";
        }

        // Check if there are binding errors
        if (result.hasErrors()) {
            return "create_student"; // Return the form view if there are validation errors
        }

        studentService.saveStudent(student);
        return "redirect:/students";
    }





    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }

    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @Valid @ModelAttribute("student") Student student,
                                BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit_student"; // Return the form view if there are validation errors
        }

        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
