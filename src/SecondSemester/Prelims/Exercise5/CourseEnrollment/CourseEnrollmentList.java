package FirstYear.SecondSemester.Prelims.Exercise5.CourseEnrollment;
import java.util.*;

/**
 * Name of Student/Programmer: MALASAN, EDISON M.
 *  * CLASS CODE & Schedule: 9322B CS122L 3:00 PM - 4:30 PM
 *  * Date: 08/02/2024
 *
 *
 * SAMPLE OUTPUT
 * How many students will be listed? : 10
 * Enter the student information here.
 * For the 1st student:
 * Enter First Name: Edison
 * Enter Middle Name: M
 * Enter Last Name: Malasan
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245504
 * For the 2nd student:
 * Enter First Name: Kim
 * Enter Middle Name: O
 * Enter Last Name: Dokja
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245501
 * For the 3rd student:
 * Enter First Name: Windsom
 * Enter Middle Name: N
 * Enter Last Name: Asura
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245502
 * For the 4th student:
 * Enter First Name: Lord
 * Enter Middle Name: G
 * Enter Last Name: Steim
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245503
 * For the 5th student:
 * Enter First Name: Grid
 * Enter Middle Name: G
 * Enter Last Name: Steim
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245505
 * For the 6th student:
 * Enter First Name: Arthur
 * Enter Middle Name: A
 * Enter Last Name: Leywin
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245506
 * For the 7th student:
 * Enter First Name: Tessia
 * Enter Middle Name: D
 * Enter Last Name: Eralith
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245507
 * For the 8th student:
 * Enter First Name: Byron
 * Enter Middle Name: V
 * Enter Last Name: Smith
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245508
 * For the 9th student:
 * Enter First Name: Arian
 * Enter Middle Name: M
 * Enter Last Name: Shirone
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245509
 * For the 10th student:
 * Enter First Name: Amy
 * Enter Middle Name: T
 * Enter Last Name: Karmis
 * Enter Course Code: CS122
 * Enter Course Name: Computer Programming 2
 * Student ID (Max 7 Numerical Digits): : 2245510
 *
 * Unsorted List
 * Last Name           First Name          Middle Name         Student ID          Course Code         Course Name
 * Malasan             Edison              M                   2245504             CS122               Computer Programming 2
 * Dokja               Kim                 O                   2245501             CS122               Computer Programming 2
 * Asura               Windsom             N                   2245502             CS122               Computer Programming 2
 * Steim               Lord                G                   2245503             CS122               Computer Programming 2
 * Steim               Grid                G                   2245505             CS122               Computer Programming 2
 * Leywin              Arthur              A                   2245506             CS122               Computer Programming 2
 * Eralith             Tessia              D                   2245507             CS122               Computer Programming 2
 * Smith               Byron               V                   2245508             CS122               Computer Programming 2
 * Shirone             Arian               M                   2245509             CS122               Computer Programming 2
 * Karmis              Amy                 T                   2245510             CS122               Computer Programming 2
 *
 *
 * Sorted List
 * Last Name           First Name          Middle Name         Student ID          Course Code         Course Name
 * Asura               Windsom             N                   2245502             CS122               Computer Programming 2
 * Dokja               Kim                 O                   2245501             CS122               Computer Programming 2
 * Eralith             Tessia              D                   2245507             CS122               Computer Programming 2
 * Karmis              Amy                 T                   2245510             CS122               Computer Programming 2
 * Leywin              Arthur              A                   2245506             CS122               Computer Programming 2
 * Malasan             Edison              M                   2245504             CS122               Computer Programming 2
 * Shirone             Arian               M                   2245509             CS122               Computer Programming 2
 * Smith               Byron               V                   2245508             CS122               Computer Programming 2
 * Steim               Grid                G                   2245505             CS122               Computer Programming 2
 * Steim               Lord                G                   2245503             CS122               Computer Programming 2
 */
public class CourseEnrollmentList {
    static Scanner kbd = new Scanner(System.in);

    public static void main(String[] args) {
        CourseEnrollmentList myProgram;
        try {
            myProgram = new CourseEnrollmentList();
            myProgram.run();
        } catch (Exception x) {
            x.printStackTrace();
        }
        System.exit(0);
    }// end of main method

    /**
     * Main control flow of the program.
     */
    public void run() {
        CourseEnrollment[] list;
        int number;

        // Read the number of the students to be listed
        number = readInteger("How many students will be listed? ",1,55);

        //Initialize the array to store course enrollments
        list = new CourseEnrollment[number];

        System.out.println("Enter the student information here.");

        //Input information for each student
        for (int i = 0; i < list.length; i++) {
            String indicator = getRank(i + 1);
            System.out.println("For the " + (i + 1) + indicator + " student: ");
            list[i] = readCourseEnrollment();
        }

        System.out.println();
        System.out.println("Unsorted List");

        //Display the unsorted list of students
        showList(list);
        System.out.println();
        System.out.println("\nSorted List");

        //sort the list of students
        sortedList(list);

        //display the sorted list of students
        showList(list);
    }


    /**
     * Display the list of students.
     *
     * @param students The array of CourseEnrollment objects representing students.
     */
    private void showList(CourseEnrollment[] students) {
        System.out.printf("%-20s%-20s%-20s%-20s%-20s%-20s%n", "Last Name", "First Name", "Middle Name", "Student ID", "Course Code", "Course Name");

        // Display information for each student
        for (CourseEnrollment student : students) {
            System.out.printf("%-20s%-20s%-20s%-20d%-20s%-20s%n",
                    student.getLastName(), student.getFirstName(), student.getMidName(),
                    student.getStudentID(), student.getCourseCode(), student.getCourseName());
        }
    }// End of showList


    /**
     * Get the ordinal indicator for a given position.
     *
     * @param indicator The position for which to get the ordinal indicator.
     * @return The ordinal indicator as a string.
     */
    private static String getRank(int indicator) { //METHOD USE FOR ORDINAL INDICATOR SO IT WILL NOT ONLY PRINT UHH PLAIN NUMBER (1 STUDENT TO 1st STUDENT )WHEN ASKING FOR INPUT

        return switch (indicator) {
            case 1 -> "st";
            case 2 -> "nd";
            case 3 -> "rd";
            default -> "th";
        };
    }// end of getRank


    /**
     * read course enrollment information for a student/method that is asking for the information of a certain student
     *
     * @return A CourseEnrollment object representing the student.
     */
    private CourseEnrollment readCourseEnrollment() {
        System.out.print("Enter First Name: ");
        String fName = kbd.nextLine();
        System.out.print("Enter Middle Name: ");
        String mName = kbd.nextLine();
        System.out.print("Enter Last Name: ");
        String lName = kbd.nextLine();
        System.out.print("Enter Course Code: ");
        String cCode = kbd.nextLine();
        System.out.print("Enter Course Name: ");
        String cName = kbd.nextLine();
        int id = readInteger("Student ID (Max 7 Numerical Digits): ", 1, 9999999);

        // new CourseEnrollment object represents the student
        CourseEnrollment s = new CourseEnrollment(fName, mName, lName, cCode, cName, id);
        return s;
    }


    /** INSERTION SORT ALGORITHM
     * sort the array of students using the insertion sort algorithm.
     *
     * @param students The array of CourseEnrollment objects representing students.
     */
    private void sortedList(CourseEnrollment[] students) {
        for (int i = 1; i < students.length; i++) {
            CourseEnrollment key = students[i];
            int j = i - 1;

            // Compare and shift elements to insert the key in the correct position
            while (j >= 0 && compareStudents(students[j], key) > 0) {
                students[j + 1] = students[j];
                j = j - 1;
            }

            // Place the key in its correct position
            students[j + 1] = key;
        }
    } // end of sortList Method


    /**
     * compare two students based on their last names and first names if the last names are the same.
     * so if the last name is the same it will compare the first name.
     *
     * @param student1 The first CourseEnrollment object representing a student.
     * @param student2 The second CourseEnrollment object representing a student.
     * @return An integer representing the comparison result.
     */
    private int compareStudents(CourseEnrollment student1, CourseEnrollment student2) {
        int lNameCompare = student1.getLastName().compareToIgnoreCase(student2.getLastName());

        if (lNameCompare == 0) {
            return student1.getFirstName().compareToIgnoreCase(student2.getFirstName());
        }

        return lNameCompare;
    }// end of compare


    /**
     * Read an integer from the user within a specified range.
     *
     * @param promptMessage The message to prompt the user.
     * @param lowLimit      The lower limit for the input value.
     * @param upLimit       The upper limit for the input value.
     * @return The valid input integer.
     */
    private int readInteger(String promptMessage, int lowLimit, int upLimit) {
        Scanner kbd = new Scanner(System.in);
        int value = -1;
        boolean validInput = false;

        //Ensure the input is a valid integer within the specific range and if its not valid it will ask again for the user input
        while (!validInput) {
            try {
                System.out.print(promptMessage + ": ");
                value = Integer.parseInt(kbd.nextLine());

                if ( value < lowLimit) {
                    System.out.println("The Input shouldn't reach negative number or low than " + lowLimit);
                } else if (value > upLimit) {
                    System.out.println("The Input shouldn't be above the " + upLimit);
                }
                else
                    validInput = true;
            } catch (NumberFormatException ex) {
                validInput = true;
                System.out.println("You entered an Invalid Integer. Please TRY AGAIN :)1");
            }//end of catch
        }// end of while
        return  value;
    }//end of readInteger Method
}// end of class
