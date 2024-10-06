package FirstYear.FirstSemester.Midterms.Exercises;

import java.lang.*;
import java.util.*;


public class GradeAverage2 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);

        String percentage;
        int grade = 50;
        int units = 0;
        int totalGrade = 0;
        int totalUnits = 0;
        double average = 0.0;
        int check = 0;

        while (check == 0) {
            System.out.print("Enter the grade of the student for the 1st subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 1st subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // OR totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 2nd subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 2nd subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;


            System.out.print("Enter the grade of the student for the 2nd subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 2nd subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 3rd subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 3rd subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 4th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 4th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 5th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 5th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 6th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 6th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 7th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 7th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 8th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 8th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 9th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 9th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            System.out.print("Enter the grade of the student for the 10th subject: ");
            grade = Integer.parseInt(kbd.nextLine());
            System.out.print("Enter the number of units for the 10th subject: ");
            units = Integer.parseInt(kbd.nextLine());

            totalGrade = totalGrade + grade * units; // totalGrade += grade* units;
            totalUnits = totalUnits + units;

            average = (totalGrade / totalUnits);

            System.out.println(" **********************************************************");
            System.out.println(" *                                                        *");
            System.out.println(" *                                                        *");
            System.out.println(" *       Your Total Grade is: " + totalGrade + "                           *");
            System.out.println(" *       The total units you have taken is: " + totalUnits + "                *");
            System.out.println(" *       Your average is: " + average + "                         *");
            System.out.println(" *                                                        *");
            System.out.println(" *                                                        *");
            System.out.println(" **********************************************************");

            if (average >= 85) {
                System.out.println("Congratulations! You belong to the dean’s list.");
            } else {
                System.out.println("Sorry you didn't pass the Average to be a Dean Lister :( (Jikai mo ganbattekudasai)");
            }
        }
    }
}