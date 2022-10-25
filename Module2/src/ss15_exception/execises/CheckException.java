package ss15_exception.execises;

public class CheckException {
    public static void checkSide(int a) throws WrongInputException {
        if (a < 0) {
            throw new WrongInputException("Number greater than 0");
        }
    }

    public static void checkSumTwoSide(int side1, int side2, int side3) throws WrongInputException {
        if (side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1)
            throw new WrongInputException("sum of 2 side is greater than 1 side ");
    }
}
