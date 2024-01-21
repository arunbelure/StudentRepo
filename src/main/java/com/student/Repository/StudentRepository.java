package com.student.Repository;

import com.student.Entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {

    public List<Student> findByYop(int yop);
}
