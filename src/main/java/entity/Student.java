package entity;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@ToString
public class Student extends Person {
    @NotNull(message = "The StudentId must have a value")
    String StudentID;
    @NotNull(message = "The FieldOfStudy must have a value")
    String FieldOfStudy;
    @NotNull(message = "The enteringYear must have a value")
    String enteringYear;
}