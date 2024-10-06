package FirstYear.SecondSemester.Prelims;
import java.util.*;
/*
MALASAN, Edison M.
9322A/B CS 112/112L
28/01/2024
 */

public class MALASANEdisonSample3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner

        int age =0;
        String name = "";
        boolean validInput = false;

        while ( !validInput ) {
            try {
                System.out.print("Please enter your age: ");
                age = Integer.parseInt(scanner.nextLine());
                validInput = true;
            } catch (NumberFormatException exception1) {
                System.out.println("Your age must be a whole number.");
                System.out.println("Problem detected "+ exception1.getMessage());
            } // end catch
        } // end while

        System.out.print("Please enter your name: ");
        name = scanner.nextLine();
        System.out.println("Hello " + name + "! Being "+ age +" years old is fun. ");
        System.exit(0);

    } // end of main
} // end of class

/*
Please enter your age: 19
Please enter your name: Edison
Hello Edison! Being 19 years old is fun.

 */
