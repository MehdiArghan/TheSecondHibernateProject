package view;

import entity.Person;
import util.PersonValidator;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Person person = new Person("", "arghan", LocalDate.of(1998, 10, 20));
        PersonRepository personRepository = new PersonRepository();
        //personRepository.save(person);
        //personRepository.update(new Person("erfan", "navab", LocalDate.of(1998, 11, 30)), 1L);
        //personRepository.delete(person);
        //personRepository.loadAll().forEach(System.out::println);
        System.out.println(PersonValidator.isValid(person));
    }
}
