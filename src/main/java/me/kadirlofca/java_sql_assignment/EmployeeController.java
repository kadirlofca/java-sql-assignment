package me.kadirlofca.java_sql_assignment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *  Defines employee API.
 */
@RestController
@RequestMapping(path="/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     *  Displays a message that confirms the program is running.
     */
    @GetMapping(path="/")
    public @ResponseBody String getMain() {
        return "java-sql-assignment is running. Please view the terminal for instructions.";
    }

    /**
     * Display all employees.
     * Accessible through /employees.
     */
    @GetMapping(path="/employees")
    public @ResponseBody Iterable<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }
}