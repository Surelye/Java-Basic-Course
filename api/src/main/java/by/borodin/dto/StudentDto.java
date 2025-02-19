package by.borodin.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Accessors(chain = true)
public class StudentDto {
    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate birthdate;
    private String email;
}
