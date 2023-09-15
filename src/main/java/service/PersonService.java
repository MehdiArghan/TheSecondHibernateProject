package service;

import entity.Person;
import repository.PersonRepository;

import java.time.LocalDate;

public class PersonService {
    PersonRepository personRepository = new PersonRepository();

    public Person singUp(String firstName, String lastName, LocalDate birthdate) {
        Person person = new Person(firstName, lastName, birthdate);
        personRepository.save(person);
        return person;
    }
}
