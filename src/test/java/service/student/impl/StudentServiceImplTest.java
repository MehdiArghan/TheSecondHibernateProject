package service.student.impl;

import entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import service.student.StudentService;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceImplTest {
    @Mock
    StudentService studentService;
    @InjectMocks
    Student student;

    @BeforeEach
    void setUp() {
        studentService = Mockito.mock(StudentServiceImpl.class);
    }

    @Test
    void signUp() {
        student = new Student();
        Student newStudent=new Student("mohammad", "sedghi", LocalDate.now(), "36"
                , "computer", "1392");
        Mockito.when(studentService.signUp("mehrab", "arghan", LocalDate.now(), "38"
                , "computer", "1400")).thenReturn(newStudent);
        assertEquals("mohammad",newStudent.getFirstName());
    }
}