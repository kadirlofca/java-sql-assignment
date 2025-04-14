package me.kadirlofca.java_sql_assignment;

import com.opencsv.bean.CsvBindByName;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

/**
 *  Holds columns from the Employee table.
 */
@Entity
public class Employee {
    public Employee(String employee_ID, String full_Name, String email, String phone_Number, String date_of_Joining, String salary, String department, String status, String manager_ID, String job_Title, String gender, String marital_Status, String dOB, String address, String city, String state, String country, String zip_Code, String emergency_Contact, String emergency_Contact_Name) {
        Employee_ID = employee_ID;
        Full_Name = full_Name;
        Email = email;
        Phone_Number = phone_Number;
        Date_of_Joining = date_of_Joining;
        Salary = salary;
        Department = department;
        Status = status;
        Manager_ID = manager_ID;
        Job_Title = job_Title;
        Gender = gender;
        Marital_Status = marital_Status;
        DOB = dOB;
        Address = address;
        City = city;
        State = state;
        Country = country;
        Zip_Code = zip_Code;
        Emergency_Contact = emergency_Contact;
        Emergency_Contact_Name = emergency_Contact_Name;
    }

    @Id
    @CsvBindByName
    private String Employee_ID;

    @CsvBindByName
    public String Full_Name;
    
    @CsvBindByName
    private String Email;

    @CsvBindByName
    private String Phone_Number;

    @CsvBindByName
    private String Date_of_Joining;

    @CsvBindByName
    private String Salary;

    @CsvBindByName
    private String Department;

    @CsvBindByName
    private String Status;

    @CsvBindByName
    private String Manager_ID;

    @CsvBindByName
    private String Job_Title;

    @CsvBindByName
    private String Gender;

    @CsvBindByName
    private String Marital_Status;

    @CsvBindByName
    private String DOB;

    @CsvBindByName
    private String Address; 

    @CsvBindByName
    private String City;

    @CsvBindByName
    private String State;

    @CsvBindByName
    private String Country;

    @CsvBindByName
    private String Zip_Code;

    @CsvBindByName
    private String Emergency_Contact;

    @CsvBindByName
    private String Emergency_Contact_Name;
}
