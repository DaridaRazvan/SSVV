package test;


import domain.Nota;
import domain.Student;
import domain.Tema;
import domain.Pair;

import org.junit.jupiter.api.Test;
import repository.NotaXMLRepository;
import repository.StudentXMLRepository;
import repository.TemaXMLRepository;
import validation.*;

import static org.junit.jupiter.api.Assertions.*;

public class Lab4InClassTest {

    //big bang testing
    @Test
    public void test_01(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",111);

        assertDoesNotThrow(() -> studentValidator.validate(student));


        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        Tema tema = new Tema("1", "description", 7, 2);
        assertNotNull(fileRepository.save(tema));


        Validator<Nota> notaValidator = new NotaValidator();
        Nota nota = new Nota(new Pair(tema.getID(),student.getID()),10,9,"asd");

        assertDoesNotThrow(() -> notaValidator.validate(nota));
    }


    //add student
    @Test
    public void addStudentRepo() {
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepository fileRepository = new StudentXMLRepository(studentValidator, "studentTest.xml");
        Student student = new Student("1", "test", 111);
        assertNotNull(fileRepository.save(student));
    }

    //integration add assignment ( add assignment + add student )
    @Test
    public void integrationAddAssignment(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        Tema tema = new Tema("1", "description", 7, 2);
        assertNotNull(fileRepository.save(tema));

        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepository fileRepositoryStudent = new StudentXMLRepository(studentValidator, "studentTest.xml");
        Student student = new Student("1", "test", 111);
        assertNotNull(fileRepositoryStudent.save(student));
    }

    //add assignment
    @Test
    public void addAssignmentRepo(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        Tema tema = new Tema("1", "description", 7, 2);
        assertNotNull(fileRepository.save(tema));
    }

    //add grade
    @Test
    public void addGradeRepo(){
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository fileRepository = new NotaXMLRepository(notaValidator,"notaTest.xml");
        Nota nota = new Nota(new Pair("1","1"),10,9,"asd");
        assertNotNull(fileRepository.save(nota));
    }

    //add grade(add student + add assignment + add grade)
    @Test
    public void integrationAddGrade(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepository fileRepositoryStudent = new StudentXMLRepository(studentValidator, "studentTest.xml");
        Student student = new Student("1", "test", 111);
        fileRepositoryStudent.save(student);


        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        Tema tema = new Tema("1", "description", 7, 2);
        fileRepository.save(tema);


        Validator<Nota> notaValidator = new NotaValidator();
        NotaXMLRepository fileRepositoryGrade = new NotaXMLRepository(notaValidator,"notaTest.xml");
        Nota nota = new Nota(new Pair(tema.getID(),student.getID()),10,9,"asd");
        assertNotNull(fileRepositoryGrade.save(nota));
    }

    @Test
    public void addStudent(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",934);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    public void addAssignment(){
        TemaValidator temaValidator = new TemaValidator();
        Tema tema = new Tema("1", "description", 7, 2);
        assertDoesNotThrow(() -> temaValidator.validate(tema));
    }

    @Test
    public void addGrade(){
        NotaValidator notaValidator = new NotaValidator();
        Nota nota = new Nota(new Pair("1","1"),10,9,"asd");
        assertDoesNotThrow(() -> notaValidator.validate(nota));
    }
}
