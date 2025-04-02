package me.kadirlofca.java_sql_assignment;

import com.opencsv.bean.CsvBindByName;

public class Employee {
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
