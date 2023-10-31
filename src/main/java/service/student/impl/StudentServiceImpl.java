package service.student.impl;

import base.service.impl.BaseServiceImpl;
import entity.Student;
import exception.CustomException;
import org.hibernate.Session;
import repository.student.StudentRepository;
import service.student.StudentService;
import util.checkValidation;

import java.time.LocalDate;

public class StudentServiceImpl extends BaseServiceImpl<Long, Student, StudentRepository> implements StudentService {

    protected final Session session;

    public StudentServiceImpl(Session session, StudentRepository repository) {
        super(session, repository);
        this.session = session;
    }

    @Override
    public Student signUp(String firstname, String lastname, LocalDate date, String StudentID, String FieldOfStudy, String enteringYear) {
        try {
            Student student = new Student(firstname, lastname, date, StudentID, FieldOfStudy, enteringYear);
            if (!checkValidation.isValid(student)) {
                throw new CustomException("Error Validation Student");
            } else {
                session.getTransaction().begin();
                repository.save(student);
                session.getTransaction().commit();
                return student;
            }
        } catch (Exception e) {
            throw new CustomException(e.getMessage());
        }
    }
}