package FirstYear.SecondSemester.Prelims;
/**
 * Name of Student/Programmer: MALASAN, EDISON M.
 * CLASS CODE & Schedule: 9322B CS122L 3:00 - 4:30
 * Date: 2/2/2024
 *
 *Student Records Keeping Using Parallel Arrays
 *
 * An ID number, a name, a course, a year level and others are
 * attributed to a student. Hence, eight arrays are
 * used: An array that stores ID numbers, an array that
 * stores names, an array that stores courses, an array
 * that stores year levels, etc. The eight arrays are treated
 * as parallel arrays such that the first elements of the
 * eight arrays are actual attributes (ID number, name, course,
 * year level, etc. ) of one student, the second elements are
 * actual attributes of another student, and so on.
 *
 * REQUIRED:
 * Complete and show a sample run (sample output) of the following
 *program.
 *The sample run should be shown below as part of this multiline comment
 *
 * SAMPLE OUTPUT
 *   How many student records will be created? : 51
 *   You must enter an integer that is not greater than 50.
 *   How many student records will be created? : 10
 *   Enter the ID Number of the 1st student: 1
 *   Enter the Name of the 1st student: EDISON
 *   Enter the Program/Course of the 1st student: BSCS
 *   Enter the Year level of the 1st student: 1
 *   Prelim Grade: 88
 *   Midterm Grade: 84
 *   Tentative Final Grade: 89
 *   Final Grade is: 87
 *   Enter the ID Number of the 2nd student: 2
 *   Enter the Name of the 2nd student: ARTHUR LEYWIN
 *   Enter the Program/Course of the 2nd student: BSCS
 *   Enter the Year level of the 2nd student: 1
 *   Prelim Grade: 89
 *   Midterm Grade: 91
 *   Tentative Final Grade: 95
 *   Final Grade is: 91
 *   Enter the ID Number of the 3rd student: 3
 *   Enter the Name of the 3rd student: KIM DOKJA
 *   Enter the Program/Course of the 3rd student: FINMAN
 *   Enter the Year level of the 3rd student: 4
 *   Prelim Grade: 92
 *   Midterm Grade: 90
 *   Tentative Final Grade: 95
 *   Final Grade is: 92
 *   Enter the ID Number of the 4th student: 4
 *   Enter the Name of the 4th student: GRID
 *   Enter the Program/Course of the 4th student: BSAC
 *   Enter the Year level of the 4th student: 3
 *   Prelim Grade: 89
 *   Midterm Grade: 88
 *   Tentative Final Grade: 92
 *   Final Grade is: 89
 *   Enter the ID Number of the 5th student: 5
 *   Enter the Name of the 5th student: WINDSOM
 *   Enter the Program/Course of the 5th student: BSMMA
 *   Enter the Year level of the 5th student: 4
 *   Prelim Grade: 86
 *   Midterm Grade: 89
 *   Tentative Final Grade: 92
 *   Final Grade is: 89
 *   Enter the ID Number of the 6th student: 6
 *   Enter the Name of the 6th student: YURA
 *   Enter the Program/Course of the 6th student: BSAC
 *   Enter the Year level of the 6th student: 4
 *   Prelim Grade: 90
 *   Midterm Grade: 92
 *   Tentative Final Grade: 96
 *   Final Grade is: 92
 *   Enter the ID Number of the 7th student: 7
 *   Enter the Name of the 7th student: STEIM
 *   Enter the Program/Course of the 7th student: BSMMA
 *   Enter the Year level of the 7th student: 1
 *   Prelim Grade: 88
 *   Midterm Grade: 85
 *   Tentative Final Grade: 91
 *   Final Grade is: 88
 *   Enter the ID Number of the 8th student: 8
 *   Enter the Name of the 8th student: HATHAWAY FLASH
 *   Enter the Program/Course of the 8th student: BSCS
 *   Enter the Year level of the 8th student: 4
 *   Prelim Grade: 92
 *   Midterm Grade: 88
 *   Tentative Final Grade: 95
 *   Final Grade is: 91
 *   Enter the ID Number of the 9th student: 9
 *   Enter the Name of the 9th student: SUNG JIN WOO
 *   Enter the Program/Course of the 9th student: BSCS
 *   Enter the Year level of the 9th student: 4
 *   Prelim Grade: 90
 *   Midterm Grade: 93
 *   Tentative Final Grade: 98
 *   Final Grade is: 93
 *   Enter the ID Number of the 10th student: 10
 *   Enter the Name of the 10th student: PIARO
 *   Enter the Program/Course of the 10th student: BSIT
 *   Enter the Year level of the 10th student: 3
 *   Prelim Grade: 97
 *   Midterm Grade: 91
 *   Tentative Final Grade: 95
 *   Final Grade is: 94
 *   Original Order Data
 *   ID Number           Name                Course              Year Level               Prelim Grade        Midterm Grade       Tentative Final Grade         Final Grade
 *   1                   EDISON              BSCS                1                        88                  84                  89                            87
 *   2                   ARTHUR LEYWIN       BSCS                1                        89                  91                  95                            91
 *   3                   KIM DOKJA           FINMAN              4                        92                  90                  95                            92
 *   4                   GRID                BSAC                3                        89                  88                  92                            89
 *   5                   WINDSOM             BSMMA               4                        86                  89                  92                            89
 *   6                   YURA                BSAC                4                        90                  92                  96                            92
 *   7                   STEIM               BSMMA               1                        88                  85                  91                            88
 *   8                   HATHAWAY FLASH      BSCS                4                        92                  88                  95                            91
 *   9                   SUNG JIN WOO        BSCS                4                        90                  93                  98                            93
 *   10                  PIARO               BSIT                3                        97                  91                  95                            94
 *   Sorted Data
 *   ID Number           Name                Course              Year Level               Prelim Grade        Midterm Grade       Tentative Final Grade         Final Grade
 *   2                   ARTHUR LEYWIN       BSCS                1                        89                  91                  95                            91
 *   1                   EDISON              BSCS                1                        88                  84                  89                            87
 *   4                   GRID                BSAC                3                        89                  88                  92                            89
 *   8                   HATHAWAY FLASH      BSCS                4                        92                  88                  95                            91
 *   3                   KIM DOKJA           FINMAN              4                        92                  90                  95                            92
 *   10                  PIARO               BSIT                3                        97                  91                  95                            94
 *   7                   STEIM               BSMMA               1                        88                  85                  91                            88
 *   9                   SUNG JIN WOO        BSCS                4                        90                  93                  98                            93
 *   5                   WINDSOM             BSMMA               4                        86                  89                  92                            89
 *   6                   YURA                BSAC                4                        90                  92                  96                            92
 *
 **/
import java.util.*;

public class MALASANEdisonStudentRecordsViaParallelArrays {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        MALASANEdisonStudentRecordsViaParallelArrays myProgram;
        try {
            myProgram = new MALASANEdisonStudentRecordsViaParallelArrays();
            myProgram.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    }

    /**
     Declare, instantiate and populate the needed arrays then perform necessary
     sorting and other manipulations
     */
    public void run() {
        String[] id; // Array that will store ID numbers
        String[] names; // Array that will store names
        String[] course;// Array that will store courses

        int[] yearLevel; // array that will store year levels
        int count; // variable that will store the number of students
        byte[] pGrade; // to store prelim grade
        byte[] mGrade; // to store midterm grade
        byte[] tFGrade; // to store tentative Final Grade
        byte[] fGrade; // to store final grade
        boolean validNumber = false;

        /* Read the number of students to be recorded from the keyboard */
        count = readInteger("How many student records will be created? ",1,50);
/* When testing your program, enter a few number of students (e.g. 5) so
that your test will not need a lot of inputs */

        /* TO DO: Instantiate the arrays such that each will have a length=size */
        id = new String[count];
        names = new String[count];
        course = new String[count];

        yearLevel = new int[count];
        pGrade = new byte[count];
        mGrade = new byte[count];
        tFGrade = new byte[count];
        fGrade = new byte[count];

        /* TO DO: Invoke the method that will fill the arrays with elements */
        populateArrays(id,names,course,yearLevel,pGrade,mGrade,tFGrade,fGrade);
        /* Show the students following the order by which they were entered */
        System.out.println("Original Order Data");
    //TO DO: Invoke the method for displaying the array elements
        showData(id,names,course,yearLevel,pGrade,mGrade,tFGrade,fGrade);
    // Show the students in sorted order
        System.out.println("Sorted Data");
        /* TO DO : Invoke the method that will sort the arrays in parallel */
        sortDataBasedOnNames(id,names,course,yearLevel,pGrade,mGrade,tFGrade,fGrade);
        // TO DO: Invoke the method for displaying the array elements
        showData(id,names,course,yearLevel,pGrade,mGrade,tFGrade,fGrade);
    }
    /**
     * Put elements into arrays (parallel arrays) for ID numbers, names, course,
     * year levels, prelim grade, midterm grade, tentative final grade, and
     * final grade
     **/
    public void populateArrays(String[] id, String[] n, String[] c, int[] y, byte[]
            p, byte[] m, byte[] t, byte[] f) {
        //TO DO. Insert appropriate lines of codes

/* When accepting a value of prelim grade, midterm grade and tentative final
grade, validate the input in order to ensure that the value entered is an integer
in the range 65 to 99 */

/* The final grade should be computed as the average of the prelim grade,
Midterm grade and tentative final grade */

        //for loop that accepts user input on each array depends on the numbers of student record created on count
        for (int i = 0; i < id.length; i++) {
            String numLetters = getRank(i + 1);

            System.out.print("Enter the ID Number of the "+ (i + 1) + numLetters + " student: ");
            id[i] = keyboard.nextLine();

            System.out.print("Enter the Name of the "+ (i + 1) + numLetters + " student: ");
            n[i] = keyboard.nextLine();

            System.out.print("Enter the Program/Course of the "+ (i + 1) + numLetters + " student: ");
            c[i] = keyboard.nextLine();

            System.out.print("Enter the Year level of the "+ (i + 1) + numLetters + " student: ");
            y[i] = Integer.parseInt(keyboard.nextLine());

            System.out.print("Prelim Grade: ");
            p[i] = keyboard.nextByte();

            System.out.print("Midterm Grade: ");
            m[i] = keyboard.nextByte();

            System.out.print("Tentative Final Grade: ");
            t[i] = keyboard.nextByte();

            keyboard.nextLine();

            f[i] = (byte) ((p[i] + m[i] + t[i]) / 3.0); //formula for getting the final grade
            System.out.println("Final Grade is: " + f[i]);

        }
    }
    private static String getRank(int i) { //METHOD USE FOR ORDINAL INDICATOR SO IT WILL NOT ONLY PRINT UHH PLAIN NUMBER (1 STUDENT TO 1st STUDENT )WHEN ASKING FOR INPUT

        return switch (i) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }

    /** Sort the elements of the eight arrays in parallel (i.e. When
     * there is a need to swap elements of the array n,
     * the corresponding elements in other arrays should also
     * be swapped.) such that the elements of array n
     * are lexicographically arranged. SPECIFY the Sort Algorithm
     * that you will follow.
     */
    public void sortDataBasedOnNames(String[] id, String[] n, String[] c, int[]
            yLevel, byte[] p, byte[] m, byte[] t, byte[] f) {
        int name = n.length;
//TO DO. Insert appropriate lines of codes
        for (int i = 0; i < name - 1; i++) { //selection sort with compareTo Method

            int baseIndex = i;
            for (int j = i + 1; j < name; j++) {
                if (n[j].compareTo(n[baseIndex]) < 0) {
                    baseIndex = j;
                }
            }
            //swapping all elements in parallel array
            swap(id, i, baseIndex);
            swap(n, i, baseIndex);
            swap(c, i, baseIndex);
            swap(yLevel, i, baseIndex);
            swap(p, i, baseIndex);
            swap(m, i, baseIndex);
            swap(t, i, baseIndex);
            swap(f, i, baseIndex);
        }
    } // end of sortBasedOnNames method
    private static void swap(String[] array, int i, int j) {//METHOD TO SWAP STRING
        String temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void swap(int[] array, int i, int j) {//METHOD TO SWAP INT
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    private static void swap(byte[] array, int i, int j) {//METHOD TO SWAP BYTE
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * Show the elements of the arrays on the screen.
     **/
    public void showData(String[] id, String[] n, String[] c, int[] y, byte[] p,
                         byte[] m, byte[] t, byte[] f) {
        //TO DO. Insert appropriate lines of codes
        //FORMAT OF SHOW DATA
        System.out.println(String.format("%-20s%-20s%-20s%-25s%-20s%-20s%-30s%-20s",
                "ID Number", "Name", "Course", "Year Level", "Prelim Grade", "Midterm Grade", "Tentative Final Grade", "Final Grade"));

        for (int i = 0; i < id.length; i++){
            System.out.println(String.format("%-20s%-20s%-20s%-25s%-20s%-20s%-30s%-20s",
                    id[i], n[i], c[i], y[i], p[i], m[i], t[i], f[i]));
        }

    } // end of showData method
    /** Returns an integer read from the keyboard. The integer must be
     * in the range lowLimit to upLimit.
     */
    public int readInteger(String promptMessage, int lowLimit, int upLimit){
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        boolean validValueRead = false;
        while( !validValueRead) {
            try { System.out.print(promptMessage + ": ");
                value = Integer.parseInt(scanner.nextLine());
                if (value < lowLimit ){
                    System.out.println("You must enter an integer that is not lower than "+lowLimit+".");
                } else
                if (value > upLimit) {
                    System.out.println("You must enter an integer that is not greater than "+ upLimit+".");
                } else
                    validValueRead = true;
            } catch (NumberFormatException x){

                validValueRead = false;
                System.out.println("You may have entered an invalid integer.");
                System.out.println("Problem Detected "+ x.getMessage() + " Please Try again. ");
            } // end of catch
        } // end of while
        return value;
    } // end of readInteger
} // end of StudentRecordsViaParallelArrays class
