package me.kadirlofca.java_sql_assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EmployeeValidator implements LineValidator {

    public EmployeeValidator() {
    }

    private boolean satisfiesNotNull(String str) {
        return str != null;
    }

    private boolean satisfiesNoSpecialCharacters(String str) {
        Pattern p = Pattern.compile("[^a-zA-Z ]");
        Matcher m = p.matcher(str);
        return !m.find();
    }

    private boolean satisfiesEmail(String str) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@" +
                            "(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
    
        Pattern p = Pattern.compile(emailRegex);
        return str != null && p.matcher(str).matches();
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