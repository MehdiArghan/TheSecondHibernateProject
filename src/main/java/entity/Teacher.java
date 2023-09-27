package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
}