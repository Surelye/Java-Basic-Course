package by.borodin.service;

import by.borodin.dto.StudentDto;

import java.util.List;

public interface StudentService {

    List<StudentDto> getAll();

    StudentDto getById(Long id);

    StudentDto save(StudentDto student);

    StudentDto update(StudentDto student);

    void deleteById(Long id);
}