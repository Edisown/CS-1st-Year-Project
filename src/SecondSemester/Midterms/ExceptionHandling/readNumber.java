package FirstYear.SecondSemester.Midterms.ExceptionHandling;

import java.util.Scanner;

public class readNumber {
    public static void main(String[] args) {
        System.out.println(readNumber());
    }
    private static double readNumber(){
        Scanner keyboard = new Scanner(System.in);
        double valueRead=0.0;
        while (true) {
            try {
                System.out.print("Enter a number: ");
                String entry = keyboard.nextLine();
                valueRead = Double.parseDouble(entry);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please Enter a valid Number");
            }
        }
        return valueRead;
    } // end readNumber method
}
