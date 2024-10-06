package FirstYear.SecondSemester.Midterms.ExceptionHandling; /**
 One way to deal with Exception is to ignore the exception.
 Just include the statement that can produce an exception.
 If an exception is generated when the program is executing,
 the execution will stop and a runtime exception is reported
 by the computer to the user.

 NOTE: Only some EXCEPTIONS may be IGNORED.
 (i.e Unchecked Exceptions={NumberFormatException, etc.).

 Other exceptions must be handled using approaches
 illustrated as case 1 or case 2.
 (i.e. Checked Exceptions ={FileNotFoundException, etc.})

 As a Java Programmer, you have to be familiar
 with Exception classes and their categories.
 **/
import java.util.Scanner;
public class ExceptionDemo1{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;
        // Ask the user until the input is valid
        while (!validInput) {
            try {
                int result = 0;
                System.out.print("Enter an integer: ");
                result = Integer.parseInt(scanner.nextLine());
                validInput = true;
                System.out.println("read value = " + result);
                break;
            } catch (NumberFormatException e) { //throw an unchecked exception if the input is not valid
                System.out.println("You should input a valid integer. Please Try Again");
            }
        }
    }
    private static double readNumber(){
        Scanner keyboard = new Scanner(System.in);
        double valueRead=0.0;
        while (true) {
            try {
                String entry = keyboard.nextLine();
                valueRead = Double.parseDouble(entry);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please Enter a valid Number");
            }
        }
        return valueRead;
    } // end readNumber method
} // end of class
