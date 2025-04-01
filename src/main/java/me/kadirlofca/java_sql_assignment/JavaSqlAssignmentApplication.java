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
		System.out.println(".\n.");
		System.out.println("If you haven't already, please exit this tool and place your 'employee_data.csv' file in the root directory.");
		System.out.println(".\n.");
		System.out.println("[Enter] to continue...");

		new BufferedReader(new InputStreamReader(System.in)).readLine();

		if(!isEmployeeDataFilePresent()) {
			System.out.println("Couldn't find 'employee_data.csv' in root directory.");
			System.exit(0);
		}
	}

	public static void runThreadSelectionSequence() throws IOException {
		System.out.println(".\n.\nFor multi threaded process, enter 'multi'.\nEnter anything else for single threaded process.");
		BufferedReader threadReader = new BufferedReader(new InputStreamReader(System.in));
		
		if(threadReader.readLine().equals("multi")) {
			System.out.println("Multi threaded process started!\n.\n.");
			runMultiThreadedProcess();
		}
		else {
			System.out.println("Single threaded process started!\n.\n.");
			runSingleThreadedProcess();
		}
	}

	public static void runSingleThreadedProcess() {
		try {
			CSVReader reader = new CSVReaderBuilder(new FileReader("employee_data.csv")).build();
			for(String[] nextLine : reader) {
				System.out.println(nextLine[0] + nextLine[1] + "etc...");
			}
		}
		catch (Exception e) {
			System.err.println(e);
		}

		// CSVReader reader = new CSVReaderBuilder(new FileReader("dataset.csv")).build();
		// CSVIterator iterator = new CSVIterator(reader);
		// for(String[] nextLine : iterator) {
		// 	// nextLine[] is an array of values from the line
		// 	System.out.println(nextLine[0] + nextLine[1] + "etc...");
     	// }
	}

	public static void runMultiThreadedProcess() {
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
