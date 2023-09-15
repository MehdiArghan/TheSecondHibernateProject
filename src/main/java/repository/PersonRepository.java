package repository;

import Connection.HibernateUtil;
import entity.Person;
import org.hibernate.Session;
import org.hibernate.TransactionException;
import org.hibernate.query.Query;

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

    public void deleteById(Long ID) {
        try {
            session.getTransaction().begin();
            Query query = session.createQuery(
                    "delete from Person e where e.id=: ID");
            query.setParameter("ID", ID);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public void updateById(Person person, Long id) {
        try {
            session.getTransaction().begin();
            Query query =
                    session.createQuery(
                            "UPDATE Person set firstName=:firstName,lastName=:lastName," +
                                    "birthDate=:birthDate where id=:id");
            query.setParameter("firstName", person.getFirstName());
            query.setParameter("lastName", person.getLastName());
            query.setParameter("birthDate", person.getBirthDate());
            query.setParameter("id", id);
            query.executeUpdate();
            session.getTransaction().commit();
        } catch (TransactionException e) {
            session.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public List<Person> loadAll(){
        return session.createQuery("from Person ",Person.class).getResultList();
    }
}
