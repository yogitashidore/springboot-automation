package net.shadervertex.sms.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import net.shadervertex.sms.entity.Student;
import net.shadervertex.sms.repository.StudentRepository;
import net.shadervertex.sms.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }


    @Override
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}




    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}