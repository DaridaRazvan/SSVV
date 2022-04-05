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

    @Test
    public void test_02(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        Tema tema = new Tema("1", "description", 7, 2);
        assertNotNull(fileRepository.save(tema));
    }

    @Test
    public void test_03(){
        StudentValidator studentValidator = new StudentValidator();
        StudentXMLRepository fileRepository = new StudentXMLRepository(studentValidator, "studentTest.xml");
        Student student = new Student("1","test",111);
        assertNotNull(fileRepository.save(student));
    }

    @Test
    public void test_04(){
        NotaValidator notaValidator = new NotaValidator();
        NotaXMLRepository fileRepository = new NotaXMLRepository(notaValidator,"notaTest.xml");
        Nota nota = new Nota(new Pair("1","1"),10,9,"asd");
        assertNotNull(fileRepository.save(nota));
    }
}
