package entity;

import base.entity.BaseEntity;
import jakarta.persistence.*;
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
@ToString
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public class Person extends BaseEntity<Long> {
    @NotNull(message = "The firstName must have a value")
    @Size(min = 2, max = 10, message = "Invalid firstName, Size should be between 2 to 10")
    String firstName;
    @NotNull(message = "The lastName must have a value")
    String lastName;
    @NotNull(message = "Invalid Date. Please enter your Date")
    @Temporal(TemporalType.DATE)
    LocalDate birthDate;

    public Person(String firstName, String lastName, LocalDate birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
