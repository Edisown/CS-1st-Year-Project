package FirstYear.SecondSemester.Prelims;
import java.util.*;
/*
MALASAN, Edison M.
9322A/B CS 112/112L
28/01/2024
 */

public class MALASANEdisonSample2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner

        int age =0;
        String name = "";


        System.out.print("Please enter your age: ");
        age = Integer.parseInt(scanner.nextLine());
        System.out.print("Please enter your name: ");
        name = scanner.nextLine(); // user input

        System.out.println("Hello " + name + "! Being "+ age +" years old is fun. ");
        System.exit(0);

    } // end of main
} // end of class

/*
Please enter your age: 17
Please enter your name: Edison Malasan
Hello Edison Malasan! Being 17 years old is fun.

 */
