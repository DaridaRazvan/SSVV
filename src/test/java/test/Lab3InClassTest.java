package test;

import domain.Nota;
import domain.Tema;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import repository.TemaXMLRepository;
import validation.NotaValidator;
import validation.TemaValidator;
import validation.ValidationException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class Lab3InClassTest {

    @Before
    public void delete(){
        //TemaValidator temaValidator = new TemaValidator();
        //TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");
        //fileRepository.delete("1");
    }

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
    public void addAssignmentInvalid(){
        TemaValidator temaValidator = new TemaValidator();
        TemaXMLRepository fileRepository = new TemaXMLRepository(temaValidator, "temaTest.xml");

        Tema tema = new Tema("2", "description", 7, 20);
        //Exception exception = assertThrows(ValidationException.class,
        //        () ->fileRepository.save(tema));
        assertNull(fileRepository.save(tema));
    }
}
