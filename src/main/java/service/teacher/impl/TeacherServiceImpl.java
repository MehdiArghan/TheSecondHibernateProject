package service.teacher.impl;

import base.service.impl.BaseServiceImpl;
import entity.Teacher;
import entity.TeacherEnum;
import exception.CustomException;
import org.hibernate.Session;
import repository.teacher.TeacherRepository;
import service.teacher.TeacherService;
import util.checkValidation;

import java.time.LocalDate;

public class TeacherServiceImpl extends BaseServiceImpl<Long, Teacher, TeacherRepository> implements TeacherService {
    protected final Session session;

    public TeacherServiceImpl(Session session, TeacherRepository repository) {
        super(session, repository);
        this.session = session;
    }


    @Override
    public Teacher signUp(String firstname, String lastname, LocalDate date, String teacherId, String degreeOfEducation
            , TeacherEnum teacherEnum, Double salary) {
        try {
            Teacher teacher = new Teacher(firstname, lastname, date, teacherId, degreeOfEducation
                    , teacherEnum, salary);
            if (!checkValidation.isValid(teacher)) {
                throw new CustomException("Error Validation teacher");
            } else {
                session.getTransaction().begin();
                repository.save(teacher);
                session.getTransaction().commit();
                return teacher;
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}