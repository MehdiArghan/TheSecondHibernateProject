package service.student;

import base.service.BaseService;
import entity.Student;

public interface StudentService extends BaseService<Long, Student> {
    Student signUp(String StudentID, String FieldOfStudy,String enteringYear);
}
