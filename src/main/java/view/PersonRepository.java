package view;

import base.repository.util.HibernateUtil;
import entity.Person;
import jakarta.persistence.NoResultException;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Optional;


public class PersonRepository {
    Session session = HibernateUtil.getSessionFactory().openSession();

    public void save(Person person) {
        try {
            session.getTransaction().begin();
            session.persist(person);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public void delete(Person person) {
        try {
            session.getTransaction().begin();
            session.remove(person);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public void update(Person person) {
        try {
            session.getTransaction().begin();
            session.merge(person);
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public Optional<Person> contains(String firstName, String lastName) {
        try {
            Query<Person> query = session.createQuery("from Person e where e.firstName=:Name and e.lastName=:Family", Person.class)
                    .setParameter("Name", firstName)
                    .setParameter("Family", lastName);
            return Optional.of(query.getSingleResult());
        } catch (NoResultException e) {
            return Optional.empty();
        }
    }


    public boolean contains(Person person) {
        return session.contains(person);
    }

    public List<Person> loadAll() {
        return session.createQuery("from Person ", Person.class).getResultList();
    }
}
