package service.person.impl;

import base.service.impl.BaseServiceImpl;
import entity.Person;
import exception.CustomException;
import org.hibernate.Session;
import repository.person.PersonRepository;
import service.person.PersonService;
import util.checkValidation;

import java.time.LocalDate;

public class PersonServiceImpl extends BaseServiceImpl<Long, Person, PersonRepository> implements PersonService {

    protected final Session session;

    public PersonServiceImpl(Session session, PersonRepository repository) {
        super(session, repository);
        this.session = session;
    }

    @Override
    public Person singUp(String firstName, String lastName, LocalDate birthdate) {
        try {
            Person person = new Person(firstName, lastName, birthdate);
            if (!checkValidation.isValid(person)) {
                throw new CustomException("Error Validation Person");
            } else {
                session.getTransaction().begin();
                repository.save(person);
                session.getTransaction().commit();
                return person;
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}