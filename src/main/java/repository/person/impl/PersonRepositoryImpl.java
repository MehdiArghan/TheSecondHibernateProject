package repository.person.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Person;
import org.hibernate.Session;
import repository.person.PersonRepository;

public class PersonRepositoryImpl extends BaseRepositoryImpl<Long, Person> implements PersonRepository {
    protected final Session session;

    public PersonRepositoryImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public Class<Person> getEntityClass() {
        return Person.class;
    }
}
