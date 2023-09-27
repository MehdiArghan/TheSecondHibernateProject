package service;

import entity.Person;
import exception.CustomException;
import repository.PersonRepository;
import util.PersonValidator;


import java.time.LocalDate;

public class PersonService {
    PersonRepository personRepository = new PersonRepository();

    public Person singUp(String firstName, String lastName, LocalDate birthdate) {
        try {
            PersonValidator.isValid(firstName);
            PersonValidator.isValid(lastName);
            PersonValidator.isValid(birthdate);
            Person person = new Person(firstName, lastName, birthdate);
            personRepository.save(person);
            return person;
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}
