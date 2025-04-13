package me.kadirlofca.java_sql_assignment;

import org.springframework.data.repository.CrudRepository;

/**
 * Repository to manage employee data.
 */
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}