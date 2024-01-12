package entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Setter
@Getter
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity
@DiscriminatorValue(value = "teacher")
public class Teacher extends Person {
    @NotNull(message = "The teacherId must have a value")
    String teacherId;
    @NotNull(message = "The degreeOfEducation must have a value")
    String degreeOfEducation;
    @NotNull(message = "The teacherEnum must have a value")
    @Enumerated(EnumType.STRING)
    TeacherEnum teacherEnum;
    @NotNull(message = "The salary must have a value")
    Double salary;

    public Teacher(
            @NotNull(message = "The firstName must have a value")
            @Size(min = 2, max = 10, message = "Invalid firstName, Size should be between 2 to 10")
            String firstName,
            @NotNull(message = "The lastName must have a value")
            String lastName,
            @NotNull(message = "Invalid Date. Please enter your Date")
            LocalDate birthDate,
            String teacherId, String degreeOfEducation, TeacherEnum teacherEnum, Double salary)
    {
        super(firstName, lastName, birthDate);
        this.teacherId = teacherId;
        this.degreeOfEducation = degreeOfEducation;
        this.teacherEnum = teacherEnum;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "teacherId='" + teacherId + '\'' +
                ", degreeOfEducation='" + degreeOfEducation + '\'' +
                ", teacherEnum=" + teacherEnum +
                ", salary=" + salary +
                "} " + super.toString();
    }
}