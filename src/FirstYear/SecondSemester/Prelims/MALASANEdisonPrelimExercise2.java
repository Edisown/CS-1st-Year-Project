package FirstYear.SecondSemester.Prelims;
import java.util.Scanner;
/*
MALASAN, Edison M.
9322A/B CS112/112L
26/01/2024
 */

public class MALASANEdisonPrelimExercise2 {
    public static void main(String[] args) {
//#1. Prepare the facility for reading input by constructing an object of the Scanner class
        Scanner scanner = new Scanner(System.in);
// #2. Declare variables for storing floating point numbers that will be accepted as operands
        double operand1, operand2;
/* #3. Declare a variable for storing the result when the operator is applied to operand1 and
operand2 (runningResult).*/
        double runningResult = 0;

/* #4. Declare a char variable for storing an arithmetic operator that will be entered. Initialize the variable to any
character but = . */
        char operator = 'x';
        System.out.print("Enter a number: ");
        operand1 = readNumber();
        boolean firstOperatorIsValid = true;

// Use the while loop to allow repetitive execution while the operator is not equal to the = characater
        while (operator != '=' ){ // #5. Start the while loop as long as operator is not =
            operator = readOperator();
            if (firstOperatorIsValid && operator == '=') {
                System.out.println("= cannot be the first operator.");
                operator = 'x';
                continue;
            }
            firstOperatorIsValid = false;
            switch (operator) {
                case '+': // #6. What case of operator (value of operator) should be here?
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2();
                    runningResult = add(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                    break;
                case '-': // #7. What case of operator (value of operator) should be here?
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2();
                    runningResult = subtract(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                    break;
                case '*': // #8. What case of operator (value of operator) should be here?
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2();
                    runningResult = multiply(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                    break;
                case '/': // #9. What case of operator (value of operator) should be here?
                    System.out.print("Enter a number: ");
                    operand2 = readNumber2();
                    runningResult = divide(operand1, operand2);
                    System.out.println("Running Result: " + runningResult);
                    operand1 = runningResult;
                    break;
                case '=':
                    System.out.println("Final Result: " + runningResult);
            } // end of switch
        }// end of while
    }        // end of main method


/**
 The following method returns the sum of two given numbers
 Input: two numbers n1 and n2
 Output : sum of n1 and n2
 */
private static double add(double n1, double n2){

    return n1+n2;
        }
/**
 The following method returns the difference of two given numbers
 Input: two numbers n1 and n2
 Output : difference of n1 and n2
 */
private static double subtract(double n1, double n2){
        return n1-n2;
        }

/**
 The following method returns the product of two given numbers
 Input: two numbers n1 and n2
 Output : product of n1 and n2
 */
private static double multiply (double n1, double n2){
        return n1*n2;
        }
/**
 The following method returns the quotient of two given numbers
 Input: two numbers n1 and n2
 Output : quotient of n1 and n2
 */
private static double divide(double n1, double n2){
        return n1/n2;
        }
/**
 The following method returns a character read from the keyboard
 Algorithm
 1. Let operator represent a character (variable of type char)
 2. do
 2.1 Read a string
 2.3. Extract the first character of the string read and assign it to operator
 2.4. if operator is not any of + , - , * , / or = , print a message
 While the value of operator is not any of + , - , / , * or =
 3. Return the operator.
 */
private static char readOperator(){
    Scanner scan = new Scanner(System.in);
    char operator='x';
    do {
        System.out.print("Enter an operator: ");

        operator = scan.nextLine().charAt(0);
        if (operator!='+'&&operator!='-'&&operator!='*'&&operator!='/'&&operator!='='){
            System.out.println("You must enter +, -, *, / or =");
        }
    } while (operator!='+'&&operator!='-'&&operator!='*'&&operator!='/'&&operator!='=');
    return operator;
} // end of readOperator method
/**
 The following method returns a number read from the keyboard
 Algorithm:
 1. Let valueRead represent a double (variable of type double)
 2. Let repeatProcess be a boolean variable initialized to false
 3. do
 3.1. Try to read a String from the input device.
 3.2. Convert the String read into a number and assign false to repeatProcess
 3.3. If the String read cannot be converted into a number,
 catch the exception and let the process
 repeat from step 1 (set repeatProcess to true)
 after giving a message to the user saying the user
 has to enter a number
 3.4. If the String is converted into a number, assign the
 number to valueRead
 while the entered string is not convertible into a number.
 4. return valueRead.
 */
private static double readNumber(){
    Scanner scan = new Scanner(System.in);
    double valueRead=0.0;
    boolean repeatProcess = false;
    do {
        try {
            String entry = scan.nextLine();
            valueRead = Double.parseDouble(entry);
            repeatProcess = false;
        } catch (Exception x){
            repeatProcess = true;
            System.out.print("The input is not a number. Please enter a number. ");
        }
    } while (repeatProcess);
    return valueRead;
} // end readNumber method
/**
 The following method returns a number read from the keyboard
 Algorithm:
 1. Let valueRead represent a double(variable of type double)
 2. Let repeatProcess be a boolean variable initialized to true
 3. while repeatProcess is true
 3.1. Try to read a String from the input device.
 3.2. Convert the String read into a number
 3.3. If the String read cannot be converted into a number,
 catch the exception and let the process repeat from step 1

 (let repeatProcess=true) after giving a message to the user
 saying the user has to enter a number
 3.4. If the String is converted into a number, assign the number to
 valueRead
 4. return valueRead.
 */
private static double readNumber2(){
    Scanner scan = new Scanner(System.in);
    double valueRead=0.0;
    boolean repeatProcess = true;
    while (repeatProcess) {
        try {
            String entry = scan.nextLine();
            valueRead = Double.parseDouble(entry);
            repeatProcess = false;
        } catch (Exception x){
            repeatProcess = true;
            System.out.print("The input is not a number. Please enter a number. ");
        }
    }
    return valueRead;
    } // end readNumber2 method
} // end of class

/*
Enter a number: 10
Enter an operator: +
Enter a number: 10
Running Result: 20.0
Enter an operator: wwww
You must enter +, -, *, / or =
Enter an operator: -
Enter a number: 5
Running Result: 15.0
Enter an operator: *
Enter a number: 20
Running Result: 300.0
Enter an operator: /
Enter a number: 25.5
Running Result: 11.764705882352942
Enter an operator: woo
You must enter +, -, *, / or =
Enter an operator:
 */