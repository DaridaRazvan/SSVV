package test;

import domain.Nota;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.Assert.*;

public class Lab3InClassTest {


    @Test
    public void addAssignmentValid(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema("1", "description", 7, 2);
        //Assertions.assertDoesNotThrow(() -> {
        //    fileRepository.save(tema);
        //});
        assertNotNull(fileRepository.save(tema));
    }

    @Test
    public void addAssignmentInvalidId(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema(null, "description", 7, 5);
        assertNull(fileRepository.save(tema));
    }

    @Test
    public void addAssignmentInvalidStartLineTooBig(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema("2", "description", 7, 20);
        assertNull(fileRepository.save(tema));
    }

    @Test
    public void addAssignmentInvalidEndLine(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema("2", "description", -3, 2);
        assertNull(fileRepository.save(tema));
    }

    @Test
    public void addAssignmentInvalidDescription(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema("2", "", 7, 5);
        assertNull(fileRepository.save(tema));
    }
}
