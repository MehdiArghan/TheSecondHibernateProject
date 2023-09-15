package repository;

import Connection.HibernateUtil;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.TransactionException;

import java.util.List;


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

    public List<Person> loadAll() {
        return session.createQuery("from Person ", Person.class).getResultList();
    }

    public boolean contains(Person person) {
        return session.contains(person);
    }
}
