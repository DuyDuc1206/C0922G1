package algorithms;

public class CheckUtil {
    public static void checkNumber(String number) throws FormatException {
        boolean check = number.matches("[0-9]*");
        if(!check){
            throw new FormatException("Wrong number format");
        }
    }
}
