package com.student.Controller;

import com.student.Entity.Student;
import com.student.Payload.StudentDto;
import com.student.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saveInfo")
public class StudentController {

    @Autowired
    private StudentService studentservice;

    //http://localhost:8080/api/saveInfo

    @PostMapping
    public ResponseEntity<StudentDto> saveStudent (@RequestBody StudentDto studentdto){
        StudentDto studentDto = studentservice.SaveStudent(studentdto);
        return new ResponseEntity<> (studentDto,HttpStatus.CREATED) ;
    }

    //http://localhost:8080/api/saveInfo/id

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        studentservice.deleteById(id);
        return new ResponseEntity<>("post is deleted",HttpStatus.OK);
    }

    //http://localhost:8080/api/saveInfo/id

    @GetMapping ("/{id}")
    public ResponseEntity<StudentDto> findById(@PathVariable int id){
        StudentDto studentById = studentservice.getStudentById(id);
        return new ResponseEntity<>(studentById,HttpStatus.OK);
    }

    //http://localhost:8080/api/saveInfo/id

    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudentById(@PathVariable int id,@RequestBody StudentDto studentdto){
        StudentDto studentDto = studentservice.updateStudentById(id, studentdto);
        return new ResponseEntity<>(studentDto,HttpStatus.OK);
    }

    //http://localhost:8080/api/saveInfo
    @GetMapping
    public ResponseEntity<List<StudentDto>> findAllDetails(){
        List<StudentDto> allDetails = studentservice.findAllDetails();
     return new ResponseEntity<>(allDetails,HttpStatus.ACCEPTED);
    }

    //http://localhost:8080/api/saveInfo/year/2021
    @GetMapping("/year/{yop}")
    public ResponseEntity<List<StudentDto>> findByYop(@PathVariable int yop){
        List<StudentDto> byYop = studentservice.findByYop(yop);
        return new ResponseEntity<>(byYop,HttpStatus.ACCEPTED);
    }
}
