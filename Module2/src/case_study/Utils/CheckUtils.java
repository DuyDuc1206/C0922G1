package case_study.Utils;

import javax.crypto.spec.PSource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CheckUtils {
    public static void checkId(String str) throws FormatException {
        boolean check = str.matches("[1-9][0-9]?");
        if (!check) {
            throw new FormatException("Id must be in the correct format:XX !");
        }
    }
    public static void checkBookingId(String str) throws FormatException {
        boolean check = str.matches("BK[0-9]{2}");
        if (!check) {
            throw new FormatException("Id must be in the correct format:BKXX!");
        }
    }

    public static void checkName(String str) throws FormatException {
        boolean check = str.matches("^([A-Z][a-z]+[ ])+([A-Z][a-z]+)$");
        if (!check) {
            throw new FormatException("Name Is Out Of Format Exception! example: Duc Nguyen");
        }
    }

    public static void checkGender(String str) throws FormatException {
        boolean check = str.matches("(MAN)|(WOMAN)");
        if (!check) {
            throw new FormatException("Gender Is Out Of Format Exception: (MAN/WOMAN)!");
        }
    }

    public static void checkDate(String str) throws FormatException {
        boolean check = str.matches("(([0][1-9])|([12][0-9])|([3][01]))/(([1][0-2])|([0][1-9]))/((19[89][0-9])|(200[0-9]))");
        if (!check) {
            throw new FormatException("Date must be in the correct format: DD/MM/YYYY !");
        }
    }

    public static void checkCardNumber(String str) throws FormatException {
        boolean check = str.matches("[0-9]{10}");
        if (!check) {
            throw new FormatException("Identity Card Number must be 10 digits!");
        }
    }

    public static void checkPhoneNumber(String str) throws FormatException {
        boolean check = str.matches("[0-9]{10}");
        if (!check) {
            throw new FormatException("Phone Number must be 10 digits!");
        }
    }

    public static void checkGmail(String str) throws FormatException {
        boolean check = str.matches("[A-Za-z0-9]*(@gmail.com)");
        if (!check) {
            throw new FormatException("Gmail must be in the correct format:@gmail.com!");
        }
    }

    public static void checkIdService(String str) throws FormatException {
        boolean check = str.matches("SV((VL)|(RO))-[0-9]{4}");
        if (!check) {
            throw new FormatException("Service code must be in the correct format: SVXX-YYYY!");
        }
    }

    public static void checkArea(double num) throws FormatException {
        if (num < 30) {
            throw new FormatException("Area must be a real number greater than 30m2!");
        }
    }

    public static void checkPrice(double num) throws FormatException {
        if (num < 0) {
            throw new FormatException("Rental cost must be a positive number!");
        }
    }

    public static void checkPeople(int num) throws FormatException {
        if (num < 0 || num >= 20) {
            throw new FormatException("The maximum number of people must be greater 0 and less than 20!");
        }
    }
    public static void checkFloor(int num) throws FormatException {
        if (num < 0) {
            throw new FormatException("The number of floor must be a positive number!");
        }
    }
    public static void checkDateRent(String str) throws FormatException {
        boolean check = str.matches("(([0][1-9])|([12][0-9])|([3][01]))/(([1][0-2])|([0][1-9]))/((201[0-9])|(202[0-2]))");
        if (!check) {
            throw new FormatException("Date must be in the correct format: DD/MM/YYYY !");
        }
    }
//    public static Date checkStartDate(String startDate) throws Exception {
//        boolean check = startDate.matches("(\\d{2}|\\d)/(\\d{2}|\\d)/\\d{4}");
//        if(!check){
//            throw new Exception("Wrong format");
//        }
//        String[] info = startDate.split("/");
//       boolean isDateException = (info[0]> LocalDate.);
//    }
    public static void checkBookingDate(String str) throws FormatException{
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        simpleDateFormat.setLenient(false);
        try{
            simpleDateFormat.parse(str);
        }catch (ParseException e){
            throw new FormatException("Date Format Exception");
        }

    }
}
