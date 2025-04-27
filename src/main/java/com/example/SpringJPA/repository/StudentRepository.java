package com.example.SpringJPA.repository;

import com.example.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDepartment(String Department);
}
