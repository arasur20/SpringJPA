package com.example.SpringJPA.controller;

import com.example.SpringJPA.model.Student;
import com.example.SpringJPA.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Student> getStudentbyId(@PathVariable("rno") int rno){
        Student student = studentService.getStudentById(rno);
        if(student==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("students")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Added", HttpStatus.CREATED);
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

    @PostMapping("students/filter")
    public List<Student> getStudentByGenderAndDepartment(@Param("gender") String gender, @Param("department") String department){
        return studentService.getStudentByGendeAndDepartment(gender, department);
    }

}
