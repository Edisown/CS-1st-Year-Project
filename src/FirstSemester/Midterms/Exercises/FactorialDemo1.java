package FirstYear.FirstSemester.Midterms.Exercises;

import java.util.Scanner;

public class FactorialDemo1 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int num;
        int fact = 1;

        System.out.print("Enter a number: ");
        num = console.nextInt();

        for (int i = 1; i <= num; i++) {//calculate
            fact *= i;
        }

        System.out.println("Factorial of " + num + " = " + fact);
        System.exit(0);
    }
}