package view;

import base.repository.util.HibernateUtil;
import entity.Person;
import entity.Student;
import entity.Teacher;
import entity.TeacherEnum;
import org.hibernate.Session;
import repository.person.PersonRepository;
import repository.person.impl.PersonRepositoryImpl;
import repository.student.StudentRepository;
import repository.student.impl.StudentRepositoryImpl;
import repository.teacher.TeacherRepository;
import repository.teacher.impl.TeacherRepositoryImpl;
import service.person.PersonService;
import service.person.impl.PersonServiceImpl;
import service.student.StudentService;
import service.student.impl.StudentServiceImpl;
import service.teacher.TeacherService;
import service.teacher.impl.TeacherServiceImpl;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Teacher teacher = new Teacher("mehdi", "arghan", LocalDate.now(),
                "147", "master", TeacherEnum.THERE, 2005.2);

        TeacherRepository teacherRepository = new TeacherRepositoryImpl(session);
        TeacherService teacherService = new TeacherServiceImpl(session, teacherRepository);
        teacherService.signUp(teacher.getFirstName(), teacher.getLastName(), teacher.getBirthDate()
                , teacher.getTeacherId(), teacher.getDegreeOfEducation(), teacher.getTeacherEnum(), teacher.getSalary());


        Student student = new Student("mohammad", "sedghi", LocalDate.now(), "36", "computer", "1392");

        StudentRepository studentRepository = new StudentRepositoryImpl(session);
        StudentService studentService = new StudentServiceImpl(session, studentRepository);
        studentService.signUp(student.getFirstName(), student.getLastName(), student.getBirthDate()
                , student.getStudentID(), student.getFieldOfStudy(), student.getEnteringYear());


        PersonRepository personRepository = new PersonRepositoryImpl(session);
        PersonService personService = new PersonServiceImpl(session, personRepository);
        personService.singUp("erfan", "navab", LocalDate.now());


        List<Person> list=personService.loadAll();
        for (Person p:list) {
            System.out.println(p);
        }
    }
}