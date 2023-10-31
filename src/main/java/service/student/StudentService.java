package service.student;

import base.service.BaseService;
import entity.Student;

import java.time.LocalDate;

public interface StudentService extends BaseService<Long, Student> {
    Student signUp(String firstname, String lastname, LocalDate date, String StudentID, String FieldOfStudy, String enteringYear);
}
