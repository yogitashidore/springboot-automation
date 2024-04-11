package net.shadervertex.sms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.shadervertex.sms.entity.Student;
import net.shadervertex.sms.repository.StudentRepository;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public int updateStudent(Student student) {
        // Save method from Spring Data JPA automatically handles update if the entity already exists
        Student updatedStudent = studentRepository.save(student);
        
        // You can return any meaningful value indicating the update operation result,
        // such as 1 for successful update, or the number of fields changed, etc.
        return (updatedStudent != null) ? 1 : 0;
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}
