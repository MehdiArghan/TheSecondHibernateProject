package repository.teacher.impl;

import base.repository.impl.BaseRepositoryImpl;
import entity.Teacher;
import org.hibernate.Session;
import repository.teacher.TeacherRepository;

public class TeacherRepositoryImpl extends BaseRepositoryImpl<Long, Teacher> implements TeacherRepository {
    protected final Session session;

    public TeacherRepositoryImpl(Session session) {
        super(session);
        this.session = session;
    }

    @Override
    public Class<Teacher> getEntityClass() {
        return Teacher.class;
    }
}
