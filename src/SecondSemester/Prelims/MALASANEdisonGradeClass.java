package FirstYear.SecondSemester.Prelims;
import java.util.*;
/*
MALASAN, Edison M.
9322A/B
CS 112/112L
26/01/2024
 */

public class MALASANEdisonGradeClass {
    public static void main( String[] args ) {
        Scanner kbd = new Scanner(System.in);

        String percentage;
        int totalGrade = 0;
        int totalUnits = 0;
        double average;
        boolean check;

        do {
            check = false;
            try {
                for (int i = 1; i <= 8; i++) {
                    String numLetters = getRank(i);

                    System.out.print("Enter the grade of the student for the " + i + numLetters + " subject: ");
                    int grade = Integer.parseInt(kbd.nextLine());

                    System.out.print("Enter the number of units for the " + i + numLetters + " subject: ");
                    int units = Integer.parseInt(kbd.nextLine());

                    if (grade < 0 || units < 0) {
                        System.out.println("Grade and Units should be positive");
                        check = true;
                        break;
                    }

                    //operations
                    totalGrade += grade * units;
                    totalUnits = totalUnits + units;
                }
                // Provide the input statement
            } catch (NumberFormatException x) {
                check = true;
                System.out.println("You have to enter a number.");
            }

        }while (check);

        average = (double) totalGrade / totalUnits;

        if( average >= 90 ){
            System.out.println( "Your Average is: "+ average +" Excellent!" );
        }
        else if( (average < 90) && (average >= 80)){
            System.out.println( "Your Average is: "+ average +" Good job!" );
        }
        else if( (average < 80) && (average >= 60)){
            System.out.println( "Your Average is: "+ average +" Study harder!" );
        }
        else{
            System.out.println( "Your Average is: "+ average +" Sorry, you failed.");
        }// end of do while loop
    }// end of main method
    private static String getRank(int i) {

        return switch (i) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    } // end of getRank Method
}// end of class

/* OUTPUT:
Enter the grade of the student for the 1st subject: 80
Enter the number of units for the 1st subject: 3
Enter the grade of the student for the 2nd subject: number
You have to enter a number.
Enter the grade of the student for the 1st subject: 90
Enter the number of units for the 1st subject: 3
Enter the grade of the student for the 2nd subject: 90
Enter the number of units for the 2nd subject: 3
Enter the grade of the student for the 3rd subject: 90
Enter the number of units for the 3rd subject: 3
Enter the grade of the student for the 4th subject: 90
Enter the number of units for the 4th subject: 3
Enter the grade of the student for the 5th subject: 90
Enter the number of units for the 5th subject: 3
Enter the grade of the student for the 6th subject: 90
Enter the number of units for the 6th subject: 3
Enter the grade of the student for the 7th subject: 90
Enter the number of units for the 7th subject: 3
Enter the grade of the student for the 8th subject: 85
Enter the number of units for the 8th subject: 3
Your Average is: 88.33333333333333 Good job!
 */
