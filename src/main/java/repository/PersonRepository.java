package repository;

import Connection.HibernateUtil;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;


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

    public void deleteById(Long ID) {
        try {
            session.getTransaction().begin();
            Query<Person> query = session.createQuery("delete from Person e where e.id=: ID");
            query.setParameter("ID", ID);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }
}
