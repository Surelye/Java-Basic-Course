package by.borodin.controller;

import by.borodin.model.Student;
import by.borodin.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) {
        return studentService.getById(id);
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable("id") Long id, @RequestBody Student student) {
        student.setId(id);
        return studentService.update(student);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable("id") Long id) {
        studentService.deleteById(id);
    }
}
