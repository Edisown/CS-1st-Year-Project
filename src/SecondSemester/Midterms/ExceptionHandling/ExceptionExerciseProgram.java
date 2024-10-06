package FirstYear.SecondSemester.Midterms.ExceptionHandling; /**
 Another way to deal with Exception is to propagate the Exception to another part of the program (pass
 the exception to another method) by using the throws clause.
 The throws clause is included in the heading of a method that can possibly produce and exception.
 The method that calls/invokes the method that can possibly produce an exception may further
 propagate the exception or it may handle the exception using a try-catch code construct.
 Below is an illustration of the approach.

 **/

import java.util.Scanner;
public class ExceptionExerciseProgram{
    public static void main(String[] args){
        ExceptionExerciseProgram test;
        try{
            test = new ExceptionExerciseProgram();
            test.run();
        }
        catch (ArithmeticException e1 ){
            System.out.println("Division was not done because the divisor is 0.");
        }
        catch (Exception e2){
            e2.printStackTrace();
        }

        finally {
            System.out.println("Demo");
            System.out.println("Thank you.");
        }
        System.exit(0);
    } // end of main method
    // A method that propagates an exception
    public void run() throws ArithmeticException, Exception{
        Scanner scanner = new Scanner(System.in);
        System.out.println("This program helps you divide whole numbers.");
        int x = readInteger("Enter the dividend");
        int y = readInteger("Enter the divisor");
        System.out.println(x+"/"+y+"="+x/y);
    } // end of run method
    // A method that handles an exception
    public int readInteger(String prompt){
        Scanner scanner = new Scanner(System.in);
        int result=0;
        boolean validValueRead = false;
        while (!validValueRead ) {
            try {
                System.out.print(prompt+ ": ");
                result =Integer.parseInt(scanner.nextLine());
                validValueRead = true;
            } catch (NumberFormatException ex){
                System.out.println("You have entered an invalid integer.");
                System.out.println(ex.getMessage());
            }
        } // end of while
        return result;
    } // end of readInteger method
} // end of class
