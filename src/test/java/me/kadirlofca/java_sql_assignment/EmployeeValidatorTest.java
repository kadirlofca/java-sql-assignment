package me.kadirlofca.java_sql_assignment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeValidatorTest {
    @Test
    void nullStringShouldBeInvalid() {
        EmployeeValidator employeeValidator = new EmployeeValidator();
        assertEquals(employeeValidator.satisfiesNotNull(null), false);
    }
}