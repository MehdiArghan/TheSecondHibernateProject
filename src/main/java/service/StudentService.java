package service;

import entity.Student;
import exception.CustomException;
import view.PersonRepository;
import util.PersonValidator;

public class StudentService {
    PersonRepository personRepository = new PersonRepository();

    public Student singUp(Student student) {
        try {
            PersonValidator.isValid(student);
            Student student1=new Student(student.getStudentID(),student.getFieldOfStudy(),student.getEnteringYear());
            personRepository.save(student1);
            return student1;
        }catch (Exception e){
            throw new CustomException("Student not save");
        }
    }
}
