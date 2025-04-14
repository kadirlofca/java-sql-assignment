package me.kadirlofca.java_sql_assignment;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * Contains logic for validating a row from the employee csv.
 */
public class EmployeeValidator implements LineValidator {
    public static Set<String> validatedIds = new HashSet<String>();

    /**
     * Validate string for unique ID constraint.
     */
    public static boolean satisfiesUniqueId(String id) {
        return validatedIds.add(id);
    }

    /**
     * Validate string for not null constraint.
     */
    public static boolean satisfiesNotNull(String str) {
        return str != null;
    }

    /**
     * Validate string for no special characters constraint.
     */
    public static boolean satisfiesNoSpecialCharacters(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Matcher m = p.matcher(str);
        return !m.find();
    }

    /**
     * Validate string for correct email format constraint.
     */
    public static boolean satisfiesEmailFormat(String str) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
        Pattern p = Pattern.compile(emailRegex);
        return str != null && p.matcher(str).matches();
    }

    /**
     * Validate string for correct date format constraint.
     */
    public static boolean satisfiesDateFormats(String str) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate.parse(str, formatter);
            return true;
        } 
        catch (DateTimeParseException yearFirstException) {
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                LocalDate.parse(str, formatter);
                return true;
            }
            catch (DateTimeException yearLastException) {
                return false;
            }
        }
    }

    
    /**
     * Checks if row is valid.
     * 
     * @param line Row from the employee csv.
     * @return True if all row columns are valid. False if row has any invalid column.
     */
    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return true;
        }

        String[] columns = line.split(",");

        String id = columns[0];
        if(!satisfiesNotNull(id) || !satisfiesUniqueId(id)) {
            return false;
        }

        String fullName = columns[1];
        if(!satisfiesNotNull(fullName) || !satisfiesNoSpecialCharacters(fullName)){
            return false;
        }

        // String email = columns[2];
        // if(!satisfiesEmail(email)){
        //      return false;           
        // }     

        return true;
    }

    /**
     * Calls isValid() and throws exception if any invalid value is found.
     */
    @Override
    public void validate(String line) throws CsvValidationException {
        if (!isValid(line)) {
            throw new CsvValidationException("Invalid row with ID=" + line.split(",")[0]);
        }
    }
}