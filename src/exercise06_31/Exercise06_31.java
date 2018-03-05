
import java.util.Scanner;

public class Exercise06_31 {

    public static void main(String[] args) {
        //Create Scanner and establish variables
        Scanner s = new Scanner(System.in);
        long sumEven = 0;
        long sumOdd = 0;
        long totalSum = 0;
        boolean isValid = true;
        String valid = "";

        //Ask user for input 
        System.out.println("Enter a credit card number as a long integer: ");
        long card = s.nextLong();
        //Send each card number to its own method and return for even or odd. 
        sumEven = sumOfDoubleEvenPlace(card);
        sumOdd = sumOfOddPlace(card);

        //Add the returns from the even and odd to be used as a final check for
        //the validity of the card. Then send this value to a boolean to check.
        totalSum = sumEven + sumOdd;
        isValid = cardValid(totalSum);

        //If statement to assign valid or invalue to boolean.
        if (isValid == true) {
            valid = "valid";
        } else {
            valid = "invalid";
        }
        //Final decision printed.
        System.out.println(card + " is " + valid);
    }

    public static long sumOfDoubleEvenPlace(long num) {
        int sum = 0;
        long temp = 0;

        while (num > 0) {
            num /= 10;
            long num1 = (num % 10) * 2;
            if (num1 >= 10) {
                temp = num1;
                num1 /= 10;
                temp %= 10;
                sum += (temp + num1);
            } else if (num1 < 10) {
                sum += num1;
            }
            num /= 10;
        }
        return sum;
    }

    public static long sumOfOddPlace(long num) {
        int sum = 0;

        while (num > 0) {
            long num1 = num % 10;
            sum += num1;
            num /= 100;
        }
        return sum;
    }

    public static boolean cardValid(long sum) {
        boolean d = true;
        if (sum % 10 == 0) {
            d = true;
        } else {
            d = false;
        }
        return d;
    }
}
