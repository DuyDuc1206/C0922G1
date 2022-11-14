package test_read_write_file.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class ValidateUtil {
    public static void validateName(String str) throws FormatException {
        boolean checkName = str.matches("[a-z]");
        if(!checkName){
            throw new FormatException("Wrong format exception");
        }
    }
    public static void validateDate(String str){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        try {
            simpleDateFormat.parse(str);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
    }
}
