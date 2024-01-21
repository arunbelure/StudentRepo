package com.student.Service;

import com.student.Entity.Student;
import com.student.Payload.StudentDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


public interface StudentService {

  public StudentDto SaveStudent(StudentDto studentdto);

  void deleteById(int id);

  StudentDto getStudentById(int id);

  StudentDto updateStudentById(int id, StudentDto studentdto);

  List<StudentDto> findAllDetails();

  List<StudentDto> findByYop(int yop);
}
