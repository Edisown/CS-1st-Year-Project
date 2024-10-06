package FirstYear.SecondSemester.Prelims;
/*
MALASAN, Edison M.
9322A/B CS 112/112L
28/01/2024
 */

public class MALASANEdisonSample5 {
    public static void main(String[] args) {
        long duration = 461012;

        System.out.printf("%d%s%n", duration, " seconds");
        System.out.printf("%08d%n", duration);
        System.out.printf("%+8d%n", duration);
        System.out.printf("%,8d%n", duration);
        System.out.printf("%+,8d%n%n", duration);
        double pi = Math.PI;
        System.out.printf("%s%n", "Value of pi = " + pi);
        System.out.printf("%.3f%n", pi);
        System.out.printf("%10.3f%n", pi);
        System.out.printf("%-10.3f%n", pi);
    } // end of main
} // end of class

/*
461012 seconds
00461012
 +461012
 461,012
+461,012

Value of pi = 3.141592653589793
3.142
     3.142
3.142

 */
