package service.teacher;

import base.service.BaseService;
import entity.Teacher;
import entity.TeacherEnum;

public interface TeacherService extends BaseService<Long, Teacher> {
    Teacher signUp(String teacherId, String degreeOfEducation, TeacherEnum teacherEnum,Double salary);
}
