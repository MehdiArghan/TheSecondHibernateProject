package service;

import entity.Teacher;
import exception.CustomException;
import repository.PersonRepository;
import util.PersonValidator;

public class TeacherService {
    PersonRepository personRepository = new PersonRepository();

    public Teacher singUp(Teacher teacher) {
        try {
            PersonValidator.isValid(teacher);
            Teacher teacher1 = new Teacher(teacher.getTeacherId(), teacher.getDegreeOfEducation()
                    , teacher.getTeacherEnum(), teacher.getSalary());
            personRepository.save(teacher1);
            return teacher1;
        } catch (Exception e) {
            throw new CustomException("Teacher not save");
        }
    }
}
