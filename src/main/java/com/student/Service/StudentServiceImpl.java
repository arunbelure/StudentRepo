package com.student.Service;

import com.student.Entity.Student;
import com.student.Payload.StudentDto;
import com.student.Repository.StudentRepository;
import com.student.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepo;

    @Override
    public StudentDto SaveStudent(StudentDto studentdto) {
        Student savedstudent = mapToEntity(studentdto);
        Student savedDto = studentRepo.save(savedstudent);
        StudentDto studentDto = mapToDto(savedDto);
        return studentDto ;
    }

    @Override
    public void deleteById(int id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student not found by id :"+id)
        );
        studentRepo.deleteById(id);
    }

    @Override
    public StudentDto getStudentById(int id) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student not found by id :" + id)
        );
        return mapToDto(student);
    }

    @Override
    public StudentDto updateStudentById(int id,StudentDto studentDto) {
        Student student = studentRepo.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("student not found by id :" + id)
        );

        student.setName(studentDto.getName());
        student.setSirName(studentDto.getSirName());
        student.setYop(studentDto.getYop());
        student.setCity(studentDto.getCity());
        student.setPercentage(studentDto.getPercentage());

        Student studDto = studentRepo.save(student);
        return mapToDto(studDto);
    }

    @Override
    public List<StudentDto> findAllDetails() {
        List<Student> StuDetails = studentRepo.findAll();
        List<StudentDto> dto = StuDetails.stream().map(s -> mapToDto(s)).collect(Collectors.toList());
        return dto;
    }

    @Override
    public List<StudentDto> findByYop(int yop) {
        List<Student> byYop = studentRepo.findByYop(yop);
        List<StudentDto> dtos = byYop.stream().map(a -> mapToDto(a)).collect(Collectors.toList());
        return dtos;
    }

    public Student mapToEntity (StudentDto dto){
        Student student = new Student();
        student.setId(dto.getId());
        student.setName(dto.getName());
        student.setCity(dto.getCity());
        student.setSirName(dto.getSirName());
        student.setPercentage(dto.getPercentage());
        student.setYop(dto.getYop());
        return student;
    }

    public StudentDto mapToDto (Student student){
        StudentDto dto = new StudentDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setCity(student.getCity());
        dto.setPercentage(student.getPercentage());
        dto.setYop(student.getYop());
        dto.setSirName(student.getSirName());
        return dto;
    }
}
