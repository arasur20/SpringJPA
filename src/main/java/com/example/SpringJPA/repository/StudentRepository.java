package com.example.SpringJPA.repository;

import com.example.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
}
