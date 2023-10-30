package service.person;

import base.service.BaseService;
import entity.Person;

import java.time.LocalDate;

public interface PersonService extends BaseService<Long, Person> {
    Person singUp(String firstName, String lastName, LocalDate birthdate);
}
