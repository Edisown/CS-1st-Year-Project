package FirstYear.SecondSemester.Prelims;
import java.lang.*;
/*
MALASAN, Edison M.
9322A/B CS 112/112L
28/01/2024
 */

public class MALASANEdisonOperatorDemo1 {
    public static void main(String[] args) {
        int count = 5;
        int adjustmentAmount = 0;
        System.out.println("Initial Count = " + count );
        adjustmentAmount = ++count * 2;
        System.out.println("Adjusted Count = " + adjustmentAmount );
        System.out.println("New Value of Count = " + count);
    } // end of main
} // end class
/* OUTPUT
Initial Count = 5
Adjusted Count = 12
New Value of Count = 6
 */