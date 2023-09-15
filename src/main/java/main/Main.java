package main;

import entity.Person;
import repository.PersonRepository;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("mehdi", "arghan", LocalDate.of(1998, 10, 20));
        PersonRepository personRepository = new PersonRepository();
        //personRepository.save(person);
        // personRepository.updateById(new Person("erfan", "navab", LocalDate.of(1998, 11, 30)), 1L);
        // personRepository.deleteById(1L);
        personRepository.loadAll().forEach(System.out::println);
    }
}
