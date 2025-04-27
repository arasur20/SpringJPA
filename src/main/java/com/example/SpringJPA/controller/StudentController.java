package com.example.SpringJPA.controller;

import com.example.SpringJPA.model.Student;
import com.example.SpringJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @GetMapping("students/{rno}")
    public Student getStudentbyId(@PathVariable("rno") int rno){
        return studentService.getStudentById(rno);
    }

    @PostMapping("students")
    public String addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return "Successfully added";
    }

    @PutMapping("students")
    public String updateStudent(@RequestBody Student student){
        studentService.updateStudent(student);
        return "Updated Successfully";
    }

    @DeleteMapping("students/{rno}")
    public String deleteStudent(@PathVariable int rno){
        studentService.deleteById(rno);
        return "Deleted Student Successfully";
    }

    @DeleteMapping("students")
    public String deleteData(){
        studentService.deleteAll();
        return "deleted Entire Data";
    }

    @GetMapping("students/department/{dept}")
    public List<Student> getStudentByDept(@PathVariable("dept") String department){
        return studentService.getStudentByDept(department);
    }

}
