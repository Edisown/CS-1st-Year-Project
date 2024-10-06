package FirstYear.SecondSemester.Midterms.MidtermProject;


import java.util.Scanner;

public class FractionTester {
    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        FractionTester ourProgram;
        try {
            ourProgram = new FractionTester();
            ourProgram.run();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void run(){
        while (true) { //Loop until a valid input is received
            // Display menu
            System.out.print("Mixed Fraction Arithmetic Program" +
                    "\nWhat do you want to do?\n" +
                    "1. Add Mixed Fractions\n" +
                    "2. Subtract Mixed Fractions\n" +
                    "3. Multiply Mixed Fractions\n" +
                    "4. Divide Mixed Fractions\n" +
                    "5. Reduce/Simplify a Mixed Fraction\n" +
                    "6. Exit\n" +
                    "Enter the number of the item: ");
            try {
                // Get the user choice
                int choice = Integer.parseInt(kbd.nextLine());

                // switch case based on users choice
                switch (choice) {
                    case 1 -> performOperation("Addition");
                    case 2 -> performOperation("Subtraction");
                    case 3 -> performOperation("Multiplication");
                    case 4 -> performOperation("Division");
                    case 5 -> reduceMixedFraction();
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

    private void performOperation(String operation) {
        MixedFraction fraction1 = inputMixedFraction("Enter the first mixed fraction:");
        MixedFraction fraction2 = inputMixedFraction("Enter the first mixed fraction:");

        MixedFraction result = switch (operation) {
            case "Addition" -> fraction1.add(fraction2);
            case "Subtraction" -> fraction1.subtract(fraction2);
            case "Multiplication" -> fraction1.multiplyBy(fraction2);
            case "Division" -> fraction1.divideBy(fraction2);
            default -> null;
        };

        if (result != null) {
            System.out.println("Result: " + result);
            System.out.println("Result in Decimal Form: " + result.toDouble());
        }
    }

    private MixedFraction inputMixedFraction(String fractions) {
        while (true) {
            // Get user input
            System.out.print(fractions + " (whole numerator/denominator): ");
            String input = kbd.nextLine().trim();

            // Check if input contains a space (indicating a mixed fraction)
            if (input.contains(" ")) {
                String[] parts = input.split(" ");

                // Extract whole, numerator, and denominator from the parts
                int whole = Integer.parseInt(parts[0]);
                String[] fractionParts = parts[1].split("/");
                int numerator = Integer.parseInt(fractionParts[0]);
                int denominator = Integer.parseInt(fractionParts[1]);

                // Create and return the MixedFraction object
                return new MixedFraction(whole, numerator, denominator);
            } else {
                // Check if input is in fraction format (numerator/denominator)
                String[] fraction = input.split("/");

                try {
                    // Parse the numerator and denominator
                    int numerator = Integer.parseInt(fraction[0]);
                    int denominator = Integer.parseInt(fraction[1]);

                    // Check if the denominator is ZERO
                    if (denominator == 0) {
                        System.out.println("Denominator can't be zero. Please enter another fraction.");
                        continue;
                    }

                    // Return the new MixedFraction object
                    return new MixedFraction(0, numerator, denominator);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException ex) {
                    System.out.println("Invalid input format. Please enter a valid fraction or mixed fraction.");
                }
            }
        }
    }

    private void reduceMixedFraction() {
        MixedFraction fraction = inputMixedFraction("Enter mixed fraction to reduce (whole numerator/denominator): ");
        fraction.reduce();
        System.out.println("Reduced Fraction: " + fraction);
    }
}
