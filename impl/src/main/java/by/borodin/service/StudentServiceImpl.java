package by.borodin.service;

import by.borodin.dto.StudentDto;
import by.borodin.mapper.StudentMapper;
import by.borodin.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> getAll() {
        return studentRepository.findAll().stream()
                .map(studentMapper::toDto)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public StudentDto getById(Long id) {
        return studentRepository.findById(id)
                .map(studentMapper::toDto)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found"));
    }

    @Override
    public StudentDto save(StudentDto studentDto) {
        return Optional.of(studentDto)
                .map(studentMapper::toStudent)
                .map(studentRepository::save)
                .map(studentMapper::toDto)
                .orElseThrow();
    }

    @Override
    public StudentDto update(StudentDto studentDto) {
        if (!studentRepository.existsById(studentDto.getId())) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }

        var student = studentMapper.toStudent(studentDto);
        studentRepository.update(student);

        return studentRepository.findById(studentDto.getId())
                .map(studentMapper::toDto)
                .get();
    }

    @Override
    public void deleteById(Long id) {
        if (!studentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Student not found");
        }
        studentRepository.deleteById(id);
    }
}
