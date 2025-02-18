package by.borodin.mapper;

import by.borodin.dto.StudentDto;
import by.borodin.entity.Student;
import org.springframework.stereotype.Component;

@Component
public class StudentMapper {

    public StudentDto toDto(Student student) {
        return new StudentDto()
                .setId(student.getId())
                .setFirstname(student.getFirstname())
                .setLastname(student.getLastname())
                .setBirthdate(student.getBirthdate())
                .setEmail(student.getEmail());
    }

    public Student toStudent(StudentDto studentDto) {
        return Student.builder()
                .id(studentDto.getId())
                .firstname(studentDto.getFirstname())
                .lastname(studentDto.getLastname())
                .birthdate(studentDto.getBirthdate())
                .email(studentDto.getEmail())
                .build();
    }
}
