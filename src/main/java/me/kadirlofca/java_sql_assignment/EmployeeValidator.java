package me.kadirlofca.java_sql_assignment;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.opencsv.exceptions.CsvValidationException;
import com.opencsv.validators.LineValidator;

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

    @Override
    public boolean isValid(String line) {
        if (line == null) {
            return true;
        }

        String[] columns = line.split(",");

        String fullName = columns[1];
        if(!satisfiesNoSpecialCharacters(fullName)){
            return false;
        }

        return true;
    }

    @Override
    public void validate(String line) throws CsvValidationException {
        if (!isValid(line)) {
            throw new CsvValidationException("Invalid row. ID=" + line.split(",")[0]);
        }
    }
}