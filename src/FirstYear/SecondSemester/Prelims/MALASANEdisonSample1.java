package FirstYear.SecondSemester.Prelims;
import java.util.*;
/*
MALASAN, Edison M.
9322A/B CS112/112L
28/01/2024
 */

public class MALASANEdisonSample1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // scanner

        int age =0;
        String name = "";

        System.out.print("Please enter your age: ");
        age = scanner.nextInt(); // user input
        scanner.nextLine();
        System.out.print("Please enter your name: ");
        name = scanner.nextLine(); // user input

        System.out.println("Hello " + name + "! Being "+ age +" years old is fun. ");
        System.exit(0);
    } // end of main
} // end of class

/*
Please enter your age: 19
Please enter your name: Malasan Edison
Hello Malasan Edison! Being 19 years old is fun.
 */
