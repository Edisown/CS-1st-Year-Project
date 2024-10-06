package FirstYear.SecondSemester.Prelims;
import java.lang.*;
import java.util.*;

public class MALASANEdisonWaterBillAnnualSummary {
    public static void main(String[] args) {
        int[] presentReading= new int[12];
        int[] startReading= new int[12];
        Scanner scanner = new Scanner(System.in);

        String consumer=""; // to hold name of consumer
        char cType = 'x'; // to hold type of consumer
        int[] nCMUsed = new int[12]; /* to hold number of cubic meters of water used for 12
months */
        int minCMResidential=12; /*to hold cut-off for minimum Bill for residential consumers */
        double minBillResidential=180.00; // minimum bill for <= 12 Cubic Meters used
        float rateResidential =30.00F; //cost of 1 Cubic Meter above the min. consumption
        int minCMCommercial=30; /* to hold cut-off for minimum Bill for commercial consumers*/
        double minBillCommercial=600.00; // minimum bill for <= 20Cubic Meters used
        float rateCommercial =50.00F; /*cost of 1 Cubic Meter above the min. consumption for commercial consumers*/

        double[] amountDue= new double[12]; // to hold the amount paid for 12 months

        showIntroduction();

        System.out.print("Enter the name of the water consumer: ");
        consumer = scanner.nextLine();
        cType = readTypeOfConsumer();
        startReading[0] = readStartReading();

        for (int index=0; index < nCMUsed.length; index++){
            presentReading[index] = readEndOfMonthReading(startReading[index], (index+1));
            if (index < (nCMUsed.length - 1))
                startReading[index+1] = presentReading[index];
            nCMUsed[index] = presentReading[index] - startReading[index];
            amountDue[index] = computeAmountDue(nCMUsed[index], cType, minCMResidential,
                    minBillResidential, minCMCommercial, minBillCommercial, rateResidential, rateCommercial);
        }

        showSummary(consumer, cType, startReading, presentReading, nCMUsed, amountDue);
        System.exit(0);

    } // end of main method


    //METHOD 1
    /**
     *Computes and returns the average of the elements an array of floating point numbers*/
    public static double computeAverage(double[] values){
        double total=0;  // to hold the total of all elements
        double average=0; // to hold the average
        for (double element : values) // add the elements
            total = total + element;
        //compute the average
        average = total/values.length ;  // total divided by number of elements
        return average;
    }

    //METHOD 2
    /**
     *Computes and returns the average of the elements an array of integers
     */
    public static double computeAverage(int[] values){
        double total=0;  // to hold the total of all elements
        double average=0; // to hold the average
        for (int element : values) // add the elements
            total = total + element;
        //compute the average
        average = (double) total/values.length ;  //total divided by number of elements
        return average;
    }

    //METHOD 3
    /**
     * The following method finds and returns the index of the element with the lowest value
     * from an array of positive integers.
     * The Linear Search algorithm is applied.*/
    public static int findLowest(int[] values){
        int indexResult = 0; // let lowest be the first element
        int currentIndex = 0;

        for (int value : values) {// find out if an element after the first is lower
            if (value < values[indexResult]) {
                indexResult = currentIndex;   // then set lowest index to the index of lower element
            }
            currentIndex++;
        }
        return values[0];
    }

    //METHOD 4
    /**
     *Finds and returns the index of the element with the highest value from an array of
     integers*/
    public static int findHighest(int[] values){
        int indexResult = 0;// let highest be the first element
        int currentIndex = 0;

        for (int value : values ) { // find out if an element after the first is higher
            if (value > values[indexResult]) {
                indexResult = currentIndex ;   //then set highest index to the index of higher element
            }
            currentIndex++;
        }
        return indexResult;
    }

    //METHOD 5
    // REQUIRED: Show the algorithm through a multiline comment
    /** Algorithm for this method
     * print a blank line
     * print annual bill summary
     * print "Name Of Consumer:" + the user Input
     * print "Type of Consumer:" (If the type is r,R then print Residential and if its c,C then PRINT Commercial
     * print "Meter reading at the beginning of year = " followed by the initial reading
     * print a table header
     * For loop that iterates over the arrays of previous, present, c and amount to display monthly details
     *print a table footer
     * Print average monthly raeding followed by the average consumption
     * print average monthly payment followed by the average amount paid
     * print month with lowest water consumption followed by the month with low consumption
     * print month with the highest water consumption followed by the month with high consumption
     * print a table footer
     * return from the method
     * **/
    public static void showSummary(String n, char t, int[] previous, int[] present, int[] c,
                                   double[] amount){
        System.out.println();
        System.out.println("Annual Water Bill Summary");
        System.out.println("Name of Consumer: " + n);
        System.out.print("Type of consumer: ");
        if (Character.toLowerCase(t) == 'r')
            System.out.println("Residential");
        if (Character.toLowerCase(t) == 'c')
            System.out.println("Commercial");
        System.out.println("Meter reading at the beginning of year  = " + previous[0] + " cubic meters");
                System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.printf("%15s%15s%15s%20s%n", "Month", "End Reading", "Consumption", "Amount Paid");
                System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        for (int index=0; index < previous.length; index++){
            System.out.printf("%15s%15d%15d%20.2f%n", monthInWord(index+1),
                    present[index],c[index] , amount[index]);
        }
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        System.out.println("Average Monthly Reading = "+ computeAverage(c));
        System.out.println("Average Monthly Payment = "+ computeAverage(amount));
        System.out.println("Month with Lowest Water Consumption = "+ monthInWord((findLowest(c)
                + 1)));
        System.out.println("Month with Highest Water Consumption = "+
                monthInWord((findHighest(c) + 1)));
        System.out.printf("%15s%15s%15s%20s%n", "---------------", "--------------", "---------------", "--------------------");
        return;
    }

    //METHOD 6
    // REQUIRED: Show the algorithm through a multiline comment
    /** Month in Woro Method
     * Initialize an empty string with a variable 'r'
     * using switch case to map the input of month/'m' to its string representation
     * for each case 1 to 12 (assign the corresponding month name to the r variable) (break out of the switch statement)
     * Return the string  representation of the month 'r'
     * **/
    public static String monthInWord(int m){
        String r="";
        switch ( m ){
            case 1 : r = "January";
                break;
            case 2 : r = "February";
                break;
            case 3 : r = "March";
                break;
            case 4 : r = "April";
                break;
            case 5 : r = "May";
                break;
            case 6 : r = "June";
                break;
            case 7 : r = "July";
                break;
            case 8 : r = "August";
                break;
            case 9 : r = "September";
                break;
            case 10 : r = "October";
                break;
            case 11 : r = "November";
                break;
            case 12 : r = "December";
        } // end of switch
        return r;
    } // end of monthInWord method

    //METHOD 7
    //REQUIRED: Provide the algorithm and the code
    public static void showIntroduction(){
        // REQUIRED: Provide the code
        //Print welcome message
        System.out.println("Welcome to the Water Bill Summary System");

        //purpose of the program
        System.out.println("The purpose of this system is to generate annual water bill summary for our consumers");

        //Instructions
        System.out.println("Please follow the instructions and what is asked so that you can have an accurate results.");
        return;
    }

    //METHOD 8
    // REQUIRED: Provide the algorithm and provide missing statements to complete the code
    /** Algorithm
     * Store the user input for the meter reading
     * boolean problemflag to track if the user input has a problem
     * use a do while loop with try catch to repeatedly prompt the user for input until it is valid
     * prompt user to enter meter reading
     * use a try catch to handle NumberFormatException
     * if exception occurs set the problem flag to true then print an error message
     * if statement use to check the entered reading if it is a negative number, If negative it will print out "The beginning meter reading cannot be negative."
     * It will repeat the loop if the reading is negative or if there is a NumberFormatException
     * return reading
     **/
    public static int readStartReading(){
        /* REQUIRED: Declare local variables */
        Scanner scanner = new Scanner(System.in);
        int reading = 0;
        boolean problemFlag;

        do {
            problemFlag = false;
            try {
                System.out.print("Enter the  meter reading at the beginning of the year: ");

                reading = Integer.parseInt(scanner.nextLine());
                // REQUIRED: Provide the input statement
            } catch (NumberFormatException x){
                problemFlag = true;
                System.out.println("You have to enter a number.");
            }
            if (reading < 0){
                System.out.println("The beginning meter reading cannot be negative.");
            }

        } while (reading < 0 || problemFlag);

        return reading;
    }

    //METHOD 9
    // REQUIRED: Provide the algorithm and provide the missing statements to complete the code
    /** Algorithm
     * Store user input for the meter reading
     * boolean pFlag to track if the user input has a problem
     * use a do while loop with try catch to repeatedly prompt the user for input until it is valid
     * prompt user to enter meter reading
     * use a try catch to handle NumberFormatException
     * if exception occurs set the pFlag to true then print an error message
     * if statement use to check the entered reading if it is less than start, If less than it will print out "Invalid datum entry! The present reading must be greater than the previous reading."
     * It will repeat the loop if the reading is less than start or if there is a NumberFormatException
     * return reading
     **/
    public static int readEndOfMonthReading(int start, int month){
        /*REQUIRED: Declare local variables */
        Scanner kbd = new Scanner(System.in);
        int reading = 0;
        boolean pFlag;

        do {
            try {
                pFlag = false;
                System.out.print("Enter the meter reading for month " + monthInWord(month) + ":");
                //REQUIRED:  Provide the necessary input statement
                reading = Integer.parseInt(kbd.nextLine());

            } catch (NumberFormatException x){
                pFlag = true;
                System.out.println("You have to enter a number.");
            }

            if (reading < start){
                System.out.println("Invalid datum entry! The present reading must be greater than the previous reading.");
            }

        } while (reading < start || pFlag);

        return reading;
    }

    //METHOD 10
    // REQUIRED: Provide the algorithm and provide the missing statements to complete the code
    /** Algorithm
     * Declare local variables t as character to store user input of type of the consumer
     * kbd (Scanner) to read input from the user
     * do while loop to repeatedly prompt the user for input until the input is valid
     * use input statement to get user input
     * check if the inputed value is (r,R,c,C)
     * if the t is not valid then it will print out an error message which is "The valid types are r for residential and c for commercial."
     * return the valid t of the consumer
     **/
    public static char readTypeOfConsumer(){
        /*REQUIRED: Declare local variables */
        Scanner kbd = new Scanner(System.in);
        char t = '0';

        do {
            System.out.print("Enter the type of the consumer< you may type r for residential or  c for commercial>: ");
            //REQUIRED: Provide needed statement(s)
            t = Character.toLowerCase(kbd.nextLine().charAt(0));

            if (t != 'r' && t != 'c'){
                System.out.println("The valid types are r for residential and c for commercial.");
            }
        } while (t != 'r' && t != 'c');

        return t;
    }

    //METHOD 11
    // REQUIRED: Show the algorithm through a multiline comment
    /** Algorithm
     * method with 8 parameters
     * declare the amount variable to 0
     * using switch case to map the input oft to its string representation
     * for each case r and R (if c is less than or equal to min1 then the amount value will be equal to minB1) (else if it is greater than then the amount value will be the result of this calculation /minB1 + (c-min1)*rate1/ )
     * BREAK THE STATEMENT
     * for each case c and C (if c is less than or equal to min2 then the amount value will be equal to minB2) (else if it is greater than then the amount value will be the result of this calculation /minB2 + (c-min2)*rate2/ )
     * Return the valid amount of the consumer
     **/
    public static double computeAmountDue(int c, char t, int min1, double minB1, int min2, double minB2, float rate1, float rate2){
        double amount = 0;
        switch (t){
            case 'r':
            case 'R':
                if ( c <= min1 ) {
                    amount = minB1;
                }
                else {
                    amount = minB1 + (c-min1)*rate1;
                }
                break;
            case 'c':
            case 'C':
                if ( c <= min2 ) {
                    amount = minB2;
                }
                else {
                    amount = minB2 + (c-min2)*rate2;
                }
        }
        return amount;
    }
}

    // end of class
    // SHOW A SAMPLE RUN OF THE PROGRAM WITHIN THIS COMMENT DELIMITERS
/*
Welcome to the Water Bill Summary System
The purpose of this system is to generate annual water bill summary for our consumers
Please follow the instructions and what is asked so that you can have an accurate results.
Enter the name of the water consumer: cons
Enter the type of the consumer< you may type r for residential or  c for commercial>: r
Enter the  meter reading at the beginning of the year: 100
Enter the meter reading for month January:100
Enter the meter reading for month February:110
Enter the meter reading for month March:120
Enter the meter reading for month April:130
Enter the meter reading for month May:140
Enter the meter reading for month June:150
Enter the meter reading for month July:160
Enter the meter reading for month August:170
Enter the meter reading for month September:180
Enter the meter reading for month October:190
Enter the meter reading for month November:200
Enter the meter reading for month December:900

Annual Water Bill Summary
Name of Consumer: cons
Type of consumer: Residential
Meter reading at the beginning of year  = 100 cubic meters
--------------- -------------------------------------------------
          Month    End Reading    Consumption         Amount Paid
--------------- -------------------------------------------------
        January            100              0              180.00
       February            110             10              180.00
          March            120             10              180.00
          April            130             10              180.00
            May            140             10              180.00
           June            150             10              180.00
           July            160             10              180.00
         August            170             10              180.00
      September            180             10              180.00
        October            190             10              180.00
       November            200             10              180.00
       December            900            700            20820.00
--------------- -------------------------------------------------
Average Monthly Reading = 66.66666666666667
Average Monthly Payment = 1900.0
Month with Lowest Water Consumption = January
Month with Highest Water Consumption = December
--------------- -------------------------------------------------
*/


