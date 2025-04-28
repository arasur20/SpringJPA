package com.example.SpringJPA.service;

import com.example.SpringJPA.model.Student;
import com.example.SpringJPA.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public Student getStudentById(int rno) {
        return studentRepository.findById(rno).orElse(null);
    }

    public void updateStudent(Student student) {
        studentRepository.save(student);
    }

    public void deleteById(int rno) {
        studentRepository.deleteById(rno);
    }

    public void deleteAll() {
        studentRepository.deleteAll();
    }

    public List<Student> getStudentByDept(String department) {
        return studentRepository.findByDepartment(department);
    }

    public List<Student> getStudentByGendeAndDepartment(String gender, String department) {
        return studentRepository.findByGenderAndDepartment(gender, department);
    }
}
