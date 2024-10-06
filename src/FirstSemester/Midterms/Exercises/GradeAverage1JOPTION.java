package FirstYear.FirstSemester.Midterms.Exercises;

import javax.swing.*;


public class GradeAverage1JOPTION {
    public static void main(String[] args) {

        // variables
        int totalGrade = 0;
        int totalUnits = 0;
        double average = 0.0;

        //for loops 1-10 subjects and subjects
        for (int i = 1; i <= 10; i++) {
            String numLetters = getRank(i);
            int grade = Integer.parseInt(JOptionPane.showInputDialog("Enter the grade of the student for the " + i + numLetters + " subject: "));
            int units = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of units for the " + i +  numLetters + " subject: "));

            //operations
            totalGrade += grade * units;
            totalUnits = totalUnits + units;
        }
        average = (double) totalGrade / totalUnits;


        //message output if all totalgrade and units calculated
        String message = "Your Total Grade is: " + totalGrade + "\n" +
                "The total units you have taken is: " + totalUnits + "\n" +
                "Your average is: " + average + "%\n\n";
        JOptionPane.showMessageDialog(null, message);

        // condition final output
        if (average >= 85) {
            message = "Congratulations! You belong to the dean’s list.";
        } else {
            message = "Sorry you didn't pass the Average to be a Dean Lister :( (Jikai mo ganbattekudasai)";
        }
        JOptionPane.showMessageDialog(null, message); //show the message congrats if conditions are met
    }

    private static String getRank(int i) {

        switch(i){
            case 1: return "st";
            case 2: return "nd";
            case 3: return "rd";
            default: return "th";
        }
    }
}

