package FirstYear.SecondSemester.Prelims.PrelimsProject;

import java.util.Scanner;

public class FractionArithmetic {
    static  Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        FractionArithmetic myProgram;
        try {
            myProgram = new FractionArithmetic();
            myProgram.run();
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.exit(0);
    }//end of main method


    /**
     * Main Control flow of the program
     */
    public void run() {
        boolean validInput = false;

        while (!validInput) { //Loop until a valid input is received
            // Display menu
            System.out.print("\nWhat do you want to do?\n" +
                    "1. Add Fractions\n" +
                    "2. Subtract Fractions\n" +
                    "3. Multiply Fractions\n" +
                    "4. Divide Fractions\n" +
                    "5. Reduce/Simplify a Fraction\n" +
                    "6. Exit\n" +
                    "Enter the number of the item: ");
            try {
                // Get the user choice
                int choice = Integer.parseInt(kbd.nextLine());

                // switch case based on users choice
                switch (choice) {
                    case 1 -> fractionAddition();
                    case 2 -> fractionSubtract();
                    case 3 -> fractionMultiply();
                    case 4 -> fractionDivision();
                    case 5 -> fractionReduce();
                    case 6 -> {
                        System.out.println("Thanks for Using Our Program. Goodbye!");
                        return;
                    }
                    default -> System.out.println("Out of Range");
                }
            } catch (NumberFormatException x) {
                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }


    /**
     * Method use to get input fraction
     *  this method is used to get an input fraction (with vinculum) from a user like "3/4" ->
     *  instead of getting the numerator and denominator one by one
     *
     * @param fractions prompt for the type of fraction to be entered
     * @return the Fraction object entered by the user
     */
    private Fraction inputFraction(String fractions) {
        while (true) {
            // Get user input
            System.out.print(fractions + " (numerator/denominator): ");
            String input = kbd.nextLine().trim();

            //check if there is spaces in the input
            if (input.contains(" ")) {
                System.out.println("Please don't put space when entering Fractions");
                continue;
            }

            // make the fraction an array of substrings base on the "/" and split it into numerator and denominator
            String[] fraction = input.split("/");

            try {
                // parseInt the numerator and denominator
                // Uhm for clear explanation
                // after the split happened it will recognize it like this
                // element of an array 0 / element of an array 1
                int numerator = Integer.parseInt(fraction[0]);
                int denominator = Integer.parseInt(fraction[1]);

                // check if the denominator is ZERO
                if (denominator == 0) {
                    System.out.println("Denominator can't be zero. Please Enter Another Fraction");
                    continue;
                }

                // Return the new Fraction object
                return new Fraction(numerator, denominator);
            } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                System.out.println("Invalid input format. Please enter a valid Fraction");
            }
        }
    }

    /**
     * Perform addition of the two provided Fractions
     */
    private void fractionAddition() {
        // Get input for the first and second fractions
        Fraction firstFraction = inputFraction("Enter The 1st Fraction");
        Fraction secondFraction = inputFraction("Enter The 2nd Fraction");

        // Perform Addition
        Fraction result = firstFraction.add(secondFraction);

        // Convert the result to its decimal form calling the toDouble method in the Reference class
        double decimalValue = result.toDouble();

        // Display Result
        System.out.printf("\nSum: " + firstFraction + " + " + secondFraction + " = " + result + " or %.2f\n ", decimalValue);
    }


    /**
     * Perform subtraction of the two provided Fractions
     */
    private void fractionSubtract() {
        // Get input for the first and second fractions
        Fraction firstFraction = inputFraction("Enter The 1st Fraction");
        Fraction secondFraction = inputFraction("Enter The 2nd Fraction");

        // Perform Subtraction
        Fraction result = firstFraction.subtraction(secondFraction);

        // Convert the result to its decimal form calling the toDouble method in the Reference class
        double decimalValue = result.toDouble();

        // Display Result
        System.out.printf("\nDifference: " + firstFraction + " - " + secondFraction + " = " + result + " or %.2f\n ", decimalValue);
    }


    /**
     * Perform multiplication of the two provided Fractions
     */
    private void fractionMultiply() {
        // Get input for the first and second fractions
        Fraction firstFraction = inputFraction("Enter The 1st Fraction");
        Fraction secondFraction = inputFraction("Enter The 2nd Fraction");

        // Perform Multiplication
        Fraction result = firstFraction.multiply(secondFraction);

        // Convert the result to its decimal form calling the toDouble method in the Reference class
        double decimalValue = result.toDouble();

        // Display Result
        System.out.printf("\nProduct: " + firstFraction + " * " + secondFraction + " = " + result + " or %.2f\n ", decimalValue);
    }


    /**
     * Perform division of the two provided Fractions
     */
    private void fractionDivision() {
        // Get input for the first and second fractions
        Fraction firstFraction = inputFraction("Enter The 1st Fraction");
        Fraction secondFraction = inputFraction("Enter The 2nd Fraction");

        // Perform Division
        Fraction result = firstFraction.division(secondFraction);

        // Convert the result to its decimal form calling the toDouble method in the Reference class
        double decimalValue = result.toDouble();

        // Display Result
        System.out.printf("\nQuotient: " + firstFraction + " / " + secondFraction + " = " + result + " or %.2f\n ", decimalValue);
    }


    /**
     * Perform reduce/simplification of the provided Fraction
     */
    private void fractionReduce() {
        // Get input for the fraction to be simplified
        Fraction simplifyFraction = inputFraction("Enter the Fraction");

        // Reduce the fraction to its simplest form calling the reduceFraction method in the Reference class
        simplifyFraction.reduceFraction();

        // Convert the simplified fraction to its decimal form calling the toDouble method in the Reference class
        double decimalValue = simplifyFraction.toDouble();

        // Display the simplified fraction and its decimal value using printf for formatting the decimal to two decimal places
        System.out.printf("Simplified Fraction: " + simplifyFraction + " or %.2f\n ", decimalValue);
    }
}
