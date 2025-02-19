package by.borodin.controller;

import by.borodin.dto.StudentDto;
import by.borodin.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentControllerImpl implements StudentController {
    private final StudentService studentService;

    @Override
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @Override
    public StudentDto getStudentById(Long id) {
        return studentService.getById(id);
    }

    @Override
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentDto saveStudent(StudentDto student) {
        return studentService.save(student);
    }

    @Override
    public StudentDto updateStudentById(Long id, StudentDto student) {
        student.setId(id);
        return studentService.update(student);
    }

    @Override
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudentById(Long id) {
        studentService.deleteById(id);
    }
}