package FirstYear.SecondSemester.Prelims;
/*
MALASAN, Edison M.
9322A/B CS 112/112L
28/01/2024
 */

public class MALASANEdisonIfElseDemo {
    public static void main(String[] args) {
        // Initialize
        int testscore = 90;
        char grade;

        if (testscore >= 90) { // if els if
            grade = 'A';
        } else if (testscore >= 80) {
            grade = 'B';
        } else if (testscore >= 70) {
            grade = 'C';
        } else if (testscore >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }
        System.out.println("Grade = " + grade);
    } // end of main
} // end of class

/* OUTPUT
Grade = A
 */