package repository;

import Connection.HibernateUtil;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.TransactionException;

public class Repository {
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
}
