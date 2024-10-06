package FirstYear.SecondSemester.Midterms.ExceptionHandling; /**

 One way to deal with Exception is to handle the Exception when it occurs by using the try-
 catch statement.

 The try-catch statement has a try block and a catch block.
 The try block has a statement that can possibly generate an exception (i.e. parseInt).
 The catch block contains codes that will execute should an exception object be generated
 by the try block.
 When a try-catch statement is executed, the try block executes first. Once an exception is
 produced by a statement in the try block, the execution flow goes to the catch block.
 Below is an illustration of the approach.
 **/
import java.util.Scanner;
public class ExceptionDemo2{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int x = readInteger();
        System.out.println("read value = " + x);
        System.exit(0);
    }



    /**
     *A method that returns an integer read from the input device.
     1. Let result represent the integer read from input device
     2. Let validValueRead be a boolean flag variable indicating whether a valid integer is read
     or not.
     Initialize validValueRead to false
     3. While a valid integer is not produced (i.e. ValuedValueRead is still false)
     Try to
     3.1. Read a String and convert the String to an integer by using the parseInt method of
     the Integer class

     ( Note that the parseInt methdo generates an exception if it is given a string that
     cannot
     be converted to an integer.)
     If no exception is generated, assign the integer to result
     Assign true to validValueRead
     else
     Give a helpful message for the user to enter a valid integer and reapeat from step
     4. return result.
     **/
    private static int readInteger(){
        Scanner scanner = new Scanner(System.in);
        int result=0;
        boolean validValueRead = false;
        while (!validValueRead ) {
            try {
                System.out.print("Enter an integer: ");
                result =Integer.parseInt(scanner.nextLine());
                validValueRead = true;

            } catch (NumberFormatException ex){
                System.out.println("You have entered an invalid integer.");
                System.out.println(ex.getMessage());
            }
        } // end of while
        return result;
    }
}