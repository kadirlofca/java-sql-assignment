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

@SpringBootApplication
public class JavaSqlAssignmentApplication {

	private static boolean isEmployeeDataFilePresent() {
		return new File("employee_data.csv").isFile();
	}

	private static void runFileValidationSequence() throws IOException {
		System.out.println("If you haven't already, please exit this tool and place your 'employee_data.csv' file in the root directory.");
		System.out.println("[Enter] to continue...");

		new BufferedReader(new InputStreamReader(System.in)).readLine();

		if(!isEmployeeDataFilePresent()) {
			System.out.println("Couldn't find 'employee_data.csv' in root directory.");
			System.exit(0);
		}
	}

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

	private static void runSingleThreadedProcess() {
		System.out.println("Single threaded not implemented yet.");
		
		// try {
		// 	CSVReader reader = new CSVReaderBuilder(new FileReader("employee_data.csv")).build();
		// 	for(String[] nextLine : reader) {
		// 		System.out.println(nextLine[0] + nextLine[1] + "etc...");
		// 	}
		// }
		// catch (Exception e) {
		// 	System.err.println(e);
		// }

		// CSVReader reader = new CSVReaderBuilder(new FileReader("dataset.csv")).build();
		// CSVIterator iterator = new CSVIterator(reader);
		// for(String[] nextLine : iterator) {
		// 	// nextLine[] is an array of values from the line
		// 	System.out.println(nextLine[0] + nextLine[1] + "etc...");
     	// }
	}

	private static void runMultiThreadedProcess() {
		try {
			FileReader reader = new FileReader("employee_data_valid.csv");
			CSVReaderBuilder builder = new CSVReaderBuilder(reader);
			CSVReader csvReader = builder.withLineValidator(new EmployeeValidator()).withSkipLines(1).build();

			csvReader.readAll();
		}
		catch (Exception e) {
			System.err.println(e);
		}
	}

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