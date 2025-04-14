package me.kadirlofca.java_sql_assignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.HashSet;
import com.opencsv.exceptions.CsvValidationException;

public class EmployeeValidatorTest {
    @Test
    void idAlreadyInSetShouldBeInvalid() {
        HashSet<String> validIds = new HashSet<String>();
        validIds.add("a");
        assertEquals(EmployeeValidator.satisfiesUniqueId("a", validIds), false);
    }

    @Test
    void nullStringShouldBeInvalid() {
        assertEquals(EmployeeValidator.satisfiesNotNull(null), false);
    }

    @Test
    void stringWithSpecialCharactersShouldBeInvalid() {
        assertEquals(EmployeeValidator.satisfiesNoSpecialCharacters(",./!@#$%^&*()"), false);
    }

    @Test
    void emailWithWrongFormatShouldBeInvalid() {
        assertEquals(EmployeeValidator.satisfiesEmailFormat("test.email.com"), false);
    }

    @Test
    void dateWithWrongFormatShouldBeInvalid() {
        assertEquals(EmployeeValidator.satisfiesDateFormats("2000-13-01"), false);
    }

    @Test
    void employeeLineWithValidValuesShouldBeValid() {
        EmployeeValidator employeeValidator = new EmployeeValidator();

        String validEmployeeLine = "84499,John Doe,johndoe@example.com,5551234,2021-02-30,58954.42,HR,Active,28160,Manager,Female,Married,1990-05-23,123 Elm St,Springfield,California,USA,90210,555-1234,Jane Doe";
        assertEquals(employeeValidator.isValid(validEmployeeLine), true);
    }

    @Test
    void employeeLineWithInvalidValueShouldThrowException() {
        EmployeeValidator employeeValidator = new EmployeeValidator();

        String invalidEmployeeLine = "84499,John@Doe,johndoe@example.com,5551234,2021-02-30,58954.42,HR,Active,28160,Manager,Female,Married,1990-05-23,123 Elm St,Springfield,California,USA,90210,555-1234,Jane Doe";
        assertThrows(CsvValidationException.class, () -> {employeeValidator.validate(invalidEmployeeLine);});
    }

}