package FirstYear.FirstSemester.Midterms.Exercises;

import java.util.Scanner;

public class PowerDemo {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);

        int base;
        int power;
        int result = 1;

        System.out.print("Enter the base: ");
        base = console.nextInt();

        System.out.print("Enter the power: ");
        power = console.nextInt();

        for (int i = 1; i <= power; i++) {//calculate power
            result *= base;
        }

        System.out.println(base + " raised to the power of " + power + " = " + result);
        System.exit(0);
    }
}
