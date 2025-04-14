package me.kadirlofca.java_sql_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * java-sql-assignment validates and extracts data from the employee csv.
 * This class guides the user through the terminal to start the process.
 */
@SpringBootApplication
public class JavaSqlAssignmentApplication {

	/**
	 * Checks if a "employee_data.csv" file exists in the root directory.
	 * @return true if file with correct name exists.
	 */
	private static boolean isEmployeeDataFilePresent() {
		return new File("employee_data.csv").isFile();
	}

	/**
	 * Guides user through csv file requirement by printing to terminal. 
	 * @throws IOException if invalid input is entered by user.
	 */
	private static void runFileValidationSequence() throws IOException {
		System.out.println("If you haven't already, please exit this tool and place your 'employee_data.csv' file in the root directory.");
		System.out.println("[Enter] to continue...");

		new BufferedReader(new InputStreamReader(System.in)).readLine();

		if(!isEmployeeDataFilePresent()) {
			System.out.println("Couldn't find 'employee_data.csv' in root directory.");
			System.exit(0);
		}
	}

	/**
	 * Guides user through thread selection process by printing to terminal.
	 * @throws IOException if invalid input is entered by user.
	 */
	private static void runThreadSelectionSequence() throws IOException {
		System.out.println("For single threaded process, enter 'single'.\nEnter anything else for multi threaded process.");
		BufferedReader threadReader = new BufferedReader(new InputStreamReader(System.in));
		
		if(threadReader.readLine().equals("single")) {
			System.out.println("Single threaded process started!");
			runSingleThreadedProcess();
		}
		else {
			System.out.println("Multi threaded process started!");
			runMultiThreadedProcess();
		}
	}

	/**
	 * Runs single threaded process.
	 */
	private static void runSingleThreadedProcess() {
		System.out.println("Single threaded not implemented yet.");
	}

    private static Employee makeEmployeeFromStringArray(String[] columns) {
        return new Employee(
                columns[0],   // Employee_ID
                columns[1],   // Full_Name
                columns[2],   // Email
                columns[3],   // Phone_Number
                columns[4],   // Date_of_Joining
                columns[5],   // Salary
                columns[6],   // Department
                columns[7],   // Status
                columns[8],   // Manager_ID
                columns[9],   // Job_Title
                columns[10],  // Gender
                columns[11],  // Marital_Status
                columns[12],  // DOB
                columns[13],  // Address
                columns[14],  // City
                columns[15],  // State
                columns[16],  // Country
                columns[17],  // Zip_Code
                columns[18],  // Emergency_Contact
                columns[19]   // Emergency_Contact_Name
        );
    }

	private static void insertValidatedEmployeesToDatabase(List<String[]> ValidatedEmployees){
		Employee newEmployee = makeEmployeeFromStringArray(ValidatedEmployees.get(0));
		EmployeeController.employeeRepository.save(newEmployee);
	}

	/**
	 * Runs multi threaded process.
	 */
	private static void runMultiThreadedProcess() {
		try {
			FileReader reader = new FileReader("employee_data_valid.csv");
			CSVReaderBuilder builder = new CSVReaderBuilder(reader);
			CSVReader csvReader = builder.withLineValidator(new EmployeeValidator()).withSkipLines(1).build();

			// insertValidatedEmployeesToDatabase(csvReader.readAll());

			csvReader.readAll();
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

	/*
	 * Runs pre-process sequences.
	 */
	public static void main(String[] args) {
		SpringApplication.run(JavaSqlAssignmentApplication.class, args);

		try {
			runFileValidationSequence();
			runThreadSelectionSequence();
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
}