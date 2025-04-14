Jacoco test coverage report 4/13/2025
![image](https://github.com/user-attachments/assets/bf3a6f4c-8907-414a-867a-6e7cf0394715)


## Queries
Retrieve all employees in a specific department.
```
SELECT *
FROM Employees
JOIN Departments ON Employees.Department = Departments.ID
WHERE Departments.Name = 'TargetDepartment'
```

Find employees who have no manager assigned.
```
SELECT *
FROM Employees
WHERE Manager_ID IS NULL;
```

List employees along with their emergency contacts.
```

```

## Normalisation
Setting up the database to minimize redundant data. For example, instead of piling customer and product data into one table, separate them to identify what a unique product is and who a unique customer is.
