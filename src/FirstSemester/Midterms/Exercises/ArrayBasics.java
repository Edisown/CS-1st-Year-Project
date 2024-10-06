package FirstYear.FirstSemester.Midterms.Exercises;

import java.util.*;

public class ArrayBasics {
    public static void main(String[] args) {
        int[] numbers = new int[5];
        int even = 0;
        int odd = 0;
        int multiplesOf4 = 0;

        Scanner kbd = new Scanner(System.in);

        //accept 20 user inputs
        for (int i = 0;i < 5; i++) {
            System.out.print("Enter Integer " + (i + 1) + ": ");
            numbers[i] = kbd.nextInt();
        }

        //calculate
        for (int i = 0; i < 5; i++) {
            int number = numbers[i];
            if (number % 2 == 0) {
                even++;
                if (number % 4 == 0) {
                    multiplesOf4++;
                }
            }else{
                odd++;
            }
        }
        System.out.println("Number of even numbers: " + even);
        System.out.println("Number of odd numbers: " + odd);
        System.out.println("Number of multiples of 4: " + multiplesOf4);
    }
}



