package FirstYear.FirstSemester.Midterms.Exercises;

import java.util.Scanner;

public class arrayBuzz {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[20];
        int[] perfectNumbers = new int[20];
        int[] buzzNumbers = new int[20];
        int perfectCount = 0, buzzCount = 0;

        //user input
        for (int i = 0; i < 20; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            numbers[i] = scanner.nextInt();
        }

        //menu
        Menu(scanner);

        //for perfect and buzz num
        for (int num : numbers) {
            int sum = 0;
            for (int i = 1; i <= num / 2; i++) {
                if (num % i == 0) {
                    sum += i;
                }
            }
            if (sum == num) {
                perfectNumbers[perfectCount++] = num;
            }
            if (num % 7 == 0 || num % 10 == 7) {
                buzzNumbers[buzzCount++] = num;
            }
        }

        // perfect numbers or buzz numbers on input
        if (PerfectNum(scanner)) {
            System.out.println("\nPerfect numbers:");
            for (int i = 0; i < perfectCount; i++) {
                System.out.print(perfectNumbers[i] + " ");
            }
        } else if (BuzzNum(scanner)) {
            System.out.println("\n\nBuzz numbers:");
            for (int i = 0; i < buzzCount; i++) {
                System.out.print(buzzNumbers[i] + " ");
            }
        }
    }

    private static void Menu(Scanner scanner) {
        System.out.println("\nChoose Display:");
        System.out.println("1. Display Perfect Numbers");
        System.out.println("2. Display Buzz Numbers");
        System.out.println("3. Exit Program");
        System.out.print("Enter your choice: ");
    }

    private static boolean PerfectNum(Scanner scanner) {
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.print("Invalid choice. Enter 1, 2, or 3: ");
            choice = scanner.nextInt();
        }
        return choice == 1;
    }

    private static boolean BuzzNum(Scanner scanner) {
        int choice = scanner.nextInt();
        while (choice != 1 && choice != 2 && choice != 3) {
            System.out.print("Invalid choice. Enter 1, 2, or 3: ");
            choice = scanner.nextInt();
        }
        return choice == 2;
    }
}