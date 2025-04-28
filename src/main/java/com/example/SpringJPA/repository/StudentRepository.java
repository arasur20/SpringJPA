package com.example.SpringJPA.repository;

import com.example.SpringJPA.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findByDepartment(String Department);

    @Query(nativeQuery = true,value = "SELECT * FROM student WHERE gender=:gender AND department =:department")
    List<Student> findByGenderAndDepartment(@Param("gender") String gender, @Param("department") String department);
}
