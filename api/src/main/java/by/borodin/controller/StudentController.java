package by.borodin.controller;

import by.borodin.dto.StudentDto;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentController {

    @GetMapping
    List<StudentDto> getAllStudents();

    @GetMapping("/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);

    @PostMapping
    StudentDto saveStudent(@RequestBody StudentDto student);

    @PutMapping("/{id}")
    StudentDto updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDto student);

    @DeleteMapping("/{id}")
    void deleteStudentById(@PathVariable("id") Long id);
}
