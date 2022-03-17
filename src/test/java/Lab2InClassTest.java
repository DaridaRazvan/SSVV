import domain.Student;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import validation.StudentValidator;
import validation.ValidationException;
import validation.Validator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class Lab2InClassTest {

    @Test
    @DisplayName("Invalid id should not work")
    public void test_1(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("","Test",921);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("ID invalid! \n", exception.getMessage());
    }

    @Test
    @DisplayName("null id should not work")
    public void test_2(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student(null,"Test",921);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("ID invalid! \n", exception.getMessage());
    }

    @Test
    @DisplayName("Invalid name should not work")
    public void test_3(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","",921);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("Nume invalid! \n", exception.getMessage());
    }

    @Test
    @DisplayName("Null name should not work")
    public void test_4(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1",null,921);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("Nume invalid! \n", exception.getMessage());
    }

    @Test
    @DisplayName("Group min bound should work")
    public void test_5(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",111);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    @DisplayName("Group high bound should work")
    public void test_6(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",937);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    @DisplayName("Group just above min bound should work")
    public void test_7(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",112);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    @DisplayName("Group just below high bound should work")
    public void test_8(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",936);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    @DisplayName("Group nominal value should work")
    public void test_9(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","test",934);

        assertDoesNotThrow(() -> studentValidator.validate(student));
    }

    @Test
    @DisplayName("Group smaller than min bound should not work")
    public void test_10(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","Test",110);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("Grupa invalida! \n", exception.getMessage());
    }

    @Test
    @DisplayName("Group bigger than max bound should not work")
    public void test_11(){
        Validator<Student> studentValidator = new StudentValidator();
        Student student = new Student("1","Test",938);

        Exception exception = assertThrows(ValidationException.class,
                () ->studentValidator.validate(student));
        assertEquals("Grupa invalida! \n", exception.getMessage());
    }
}