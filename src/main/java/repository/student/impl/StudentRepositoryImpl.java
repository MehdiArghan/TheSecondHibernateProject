package repository.student.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Student;
import org.hibernate.Session;
import repository.student.StudentRepository;

public class StudentRepositoryImpl extends BaseRepositoryImpl<Long, Student> implements StudentRepository {
    protected final Session session;

    public StudentRepositoryImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public Class<Student> getEntityClass() {
        return Student.class;
    }
}
