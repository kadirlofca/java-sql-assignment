package me.kadirlofca.java_sql_assignment;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

public class EmployeeValidator implements LineValidator {

    public EmployeeValidator() {
    }

    public static boolean satisfiesNotNull(String str) {
        return str != null;
    }

    public static boolean satisfiesNoSpecialCharacters(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Matcher m = p.matcher(str);
        return !m.find();
    }

    public static boolean satisfiesEmail(String str) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
        Pattern p = Pattern.compile(emailRegex);
        return str != null && p.matcher(str).matches();
    }

    public static boolean satisfiesDateFormats(String str) {
        String dateReges = "^(?:(?:\d{4})-(?:0[1-9]|1[0-2])-(?:0[1-9]|[12][0-9]|3[01]))$|^(?:(?:0[1-9]|[12][0-9]|3[01])-(?:0[1-9]|1[0-2])-(?:\d{4}))$";
        
    }

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return true;
        }

        String[] columns = line.split(",");

        String fullName = columns[1];
        if(!satisfiesNotNull(fullName) || !satisfiesNoSpecialCharacters(fullName)){
            return false;
        }

        String email = columns[2];
        if(!satisfiesEmail(email)){
             return false;           
        }     

        return true;
    }

    @Override
    public void validate(String line) throws CsvValidationException {
        if (!isValid(line)) {
            throw new CsvValidationException("Invalid row with ID=" + line.split(",")[0]);
        }
    }
}