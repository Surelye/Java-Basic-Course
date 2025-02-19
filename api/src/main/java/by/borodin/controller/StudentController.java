package by.borodin.controller;

import by.borodin.dto.StudentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface StudentController {

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
    @GetMapping
    List<StudentDto> getAllStudents();

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
    @GetMapping("/{id}")
    StudentDto getStudentById(@PathVariable("id") Long id);

    @Operation(summary = "Save a New Student",
            description = "Creates a new student record in the system.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
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
    @PostMapping
    StudentDto saveStudent(@RequestBody StudentDto student);

    @Operation(summary = "Update Student by ID",
            description = "Updates the details of an existing student by ID.",
            requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(
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
    @PutMapping("/{id}")
    StudentDto updateStudentById(@PathVariable("id") Long id, @RequestBody StudentDto student);

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
    @DeleteMapping("/{id}")
    void deleteStudentById(@PathVariable("id") Long id);
}
