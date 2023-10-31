package service.teacher;

import base.service.BaseService;
import entity.Teacher;
import entity.TeacherEnum;

import java.time.LocalDate;

public interface TeacherService extends BaseService<Long, Teacher> {
    Teacher signUp(String firstname, String lastname, LocalDate date, String teacherId, String degreeOfEducation, TeacherEnum teacherEnum, Double salary);
}
