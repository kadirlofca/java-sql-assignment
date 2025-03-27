package me.kadirlofca.java_sql_assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileReader;

import com.opencsv.CSVIterator;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;


@SpringBootApplication
public class JavaSqlAssignmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaSqlAssignmentApplication.class, args);

		CSVReader reader = new CSVReaderBuilder(new FileReader("dataset.csv")).build();
		CSVIterator iterator = new CSVIterator(reader);
		for(String[] nextLine : iterator) {
			// nextLine[] is an array of values from the line
			System.out.println(nextLine[0] + nextLine[1] + "etc...");
     	}

	// try {
	// 	CSVReader reader = new CSVReaderBuilder(new FileReader("dataset.csv")).build();
	// 	String [] nextLine;
	// 	while ((nextLine = reader.readNext()) != null) {
	// 		for(int i = 0; i < )
	// 	   System.out.println(nextLine[0] + nextLine[1] + "etc...");
	// 	}
	// }
	// catch (Exception e) {
	// 	System.err.println(e);
	// }
	}
}
