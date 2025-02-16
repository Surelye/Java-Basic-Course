package by.borodin.service;

import by.borodin.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAll();

    Student getById(Long id);

    Student save(Student student);

    Student update(Student student);

    void deleteById(Long id);
}
