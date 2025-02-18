package by.borodin.controller;

import by.borodin.dto.StudentDto;
import by.borodin.service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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

    @Operation(summary = "Retrieve All Students",
            description = "Fetches a list of all students registered in the system.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the list of students.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto[].class))
            )
    })
    @Override
    public List<StudentDto> getAllStudents() {
        return studentService.getAll();
    }

    @Operation(summary = "Retrieve Student by ID",
            description = "Fetch an individual student registered in the system by ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully retrieved the student by ID.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Bad student ID provided.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student with the provided ID was not found.",
                    content = @Content(mediaType = "application/json")
            )
    })
    @Override
    public StudentDto getStudentById(Long id) {
        return studentService.getById(id);
    }

    @Operation(summary = "Save a New Student",
            description = "Creates a new student record in the system.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class))
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Successfully created a new student record.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input student data provided.",
                    content = @Content(mediaType = "application/json")
            )
    })
    @Override
    @ResponseStatus(code = HttpStatus.CREATED)
    public StudentDto saveStudent(StudentDto student) {
        return studentService.save(student);
    }

    @Operation(summary = "Update Student by ID",
            description = "Updates the details of an existing student by ID.",
            requestBody = @RequestBody(
                    required = true,
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class))
            )
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Successfully updated a student record.",
                    content = @Content(
                            mediaType = "application/json",
                            schema = @Schema(implementation = StudentDto.class)
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Invalid input student data provided.",
                    content = @Content(mediaType = "application/json")
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student with the provided ID was not found.",
                    content = @Content(mediaType = "application/json")
            )
    })
    @Override
    public StudentDto updateStudentById(Long id, StudentDto student) {
        student.setId(id);
        return studentService.update(student);
    }

    @Operation(summary = "Delete Student by ID",
            description = "Deletes the record about existing student by ID.")
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "204",
                    description = "Successfully deleted a student record."
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "Student with the provided ID was not found.",
                    content = @Content(mediaType = "application/json")
            )
    })
    @Override
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteStudentById(Long id) {
        studentService.deleteById(id);
    }
}
