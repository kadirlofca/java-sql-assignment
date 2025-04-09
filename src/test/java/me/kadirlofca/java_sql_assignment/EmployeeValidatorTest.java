package me.kadirlofca.java_sql_assignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeValidatorTest {
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

    // @Test
    // void dateWithWrongFormatShouldBeInvalid() {
    //     assertEquals(EmployeeValidator.satisfiesDateFormats("2000-13-01"), false);
    // }
}