package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@DiscriminatorValue(value = "student")
public class Student extends Person {
    @NotNull(message = "The StudentId must have a value")
    String StudentID;
    @NotNull(message = "The FieldOfStudy must have a value")
    String FieldOfStudy;
    @NotNull(message = "The enteringYear must have a value")
    String enteringYear;

    public Student(String firstName, String lastName, LocalDate birthDate, String studentID, String fieldOfStudy, String enteringYear) {
        super(firstName, lastName, birthDate);
        this.StudentID = studentID;
        this.FieldOfStudy = fieldOfStudy;
        this.enteringYear = enteringYear;
    }

    @Override
    public String toString() {
        return "Student{" +
                "StudentID='" + StudentID + '\'' +
                ", FieldOfStudy='" + FieldOfStudy + '\'' +
                ", enteringYear='" + enteringYear + '\'' +
                "} " + super.toString();
    }
}