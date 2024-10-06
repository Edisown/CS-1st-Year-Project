package FirstYear.FirstSemester.Finals.FinalProject;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class FinalProject_CS112_SET_B1 {
    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int choice;

        System.out.println("""
                Welcome to our Java Program Collection
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name
                Lastname, Firstname Middle name""");
        while (true) {
            System.out.println("\nPress [ENTER] to see the Main Menu");
            if (kbd.hasNextLine()) {
                System.out.print(kbd.nextLine());
                System.out.println("Please choose among the Java Program");
                System.out.println("------------------------------------");
                System.out.println("""
                        1. Determine if a number is a Perfect, Abundant, or Deficient Number
                        2. Determine if a number is a Happy Number
                        3. Inserting an Element in an Array
                        4. Deleting an Element in an Array
                        5. Display the multiplication Table using 2D arrays
                        6. Remove all consonants in a word
                        7. Remove common letters
                        8. Exit Program""");
                System.out.println("------------------------------------");
                System.out.print("Input the number corresponding to your choice: ");
                choice = Integer.parseInt(kbd.nextLine());
                System.out.println();
                switch (choice) {
                    case 1:
                        System.out.print("Input a Number: ");
                        NumberType(kbd.nextInt());
                        break;
                    case 2:
                        System.out.print("Input a Number: ");
                        System.out.println(HappyNumber(kbd.nextInt()));
                        break;
                    case 3:
                        int[] array = new int[10];
                        fillArrayWithRandomValues(array, 100);
                        System.out.println("Array Contents: " + Arrays.toString(array) + "\n");
                        System.out.print("Position of Index: " );
                        int indexPosition = Integer.parseInt(kbd.nextLine());
                        System.out.print("Input a value you want to add: ");
                        int valuetoAdd = Integer.parseInt(kbd.nextLine());
                        insertElementInArray(array, valuetoAdd, indexPosition);
                        System.out.println("Array Contents after insertion: " + Arrays.toString(array));
                        break;
                    case 4:
                        int[] arrayToDelete = new int[10];
                        fillArrayWithRandomValues(arrayToDelete, 50);
                        System.out.println("Array Contents: " + Arrays.toString(arrayToDelete));
                        System.out.print("Enter the Number you want to delete: ");
                        int deleteNum = Integer.parseInt(kbd.nextLine());
                        deleteElementInArray(arrayToDelete, deleteNum);
                        System.out.println("Array Contents after deletion: " + Arrays.toString(arrayToDelete));
                        break;
                    case 5:
                        System.out.print("Enter the size for the multiplication table: ");
                        displayMultiplicationTable(kbd.nextInt());
                        break;
                    case 6:
                        System.out.print("Enter a word: ");
                        System.out.println("Word after removing consonants: " + removeConsonants(kbd.next()));
                        break;
                    case 7:
                        System.out.print("Enter the first word: ");
                        String firstWord = kbd.next();
                        System.out.print("Enter the second word: ");
                        String secondWord = kbd.next();
                        System.out.println("Remaining letters after removing common letters: " +
                                removeCommonLetters(firstWord, secondWord));
                        break;
                    case 8:
                        System.out.println("Thank you for using the program. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid input");
                }
            } else {
                System.out.println("error");
            }
        }
    }

    // Method 1
    private static void NumberType(int num) {
        // Determine if a number is Perfect, Abundant, or Deficient
        int sum = 0;
        for (int i = 1; i < num; sum += num % i++ == 0 ? i : 0) ;
        System.out.println(sum == num ? "Perfect Number" : sum > num ? "Abundant Number" : "Deficient Number");
    }

    // Method 2
    private static boolean HappyNumber(int num) {
        // Determine if a number is a Happy Number
        int slow = num, fast = num;
        do {
            slow = sumOfSquares(slow);
            fast = sumOfSquares(sumOfSquares(fast));
        } while (slow != fast);
        return slow == 1;
    }

    // Method 2.1
    private static int sumOfSquares(int num) {
        int sum = 0;
        while (num > 0) {
            sum += Math.pow(num % 10, 2);
            num /= 10; // Reduce num to move to the next digit
        }
        return sum;
    }

    // Fill random values (purpose: for choices 3 and 4)
    private static void fillArrayWithRandomValues(int[] array, int limit) {
        // Fill an array with random values
        Arrays.setAll(array, i -> new Random().nextInt(limit));
    }

    // Method 3
    private static void insertElementInArray(int[] array, int num, int index) {
        // Insert an element in an array at the specified index
        if (index >= 0 && index < array.length) {
            System.arraycopy(array, index, array, index + 1, array.length - index - 1);
            array[index] = num;
        } else System.out.println("Invalid index. Element not inserted.");
    }

    // Method 4
    private static void deleteElementInArray(int[] array, int num) {
        // Delete an element in an array
        boolean found = false;
        for (int i = 0; i < array.length; i++)
            if (array[i] == num) {
                found = true;
                System.arraycopy(array, i + 1, array, i, array.length - i - 1);
                array[array.length - 1] = 0;
            }
        if (!found) System.out.println("Number not found in the array.");
    }

    // Method 5
    private static void displayMultiplicationTable(int size) {
        // Display the multiplication table
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }

    // Method 6
    private static String removeConsonants(String word) {
        // Remove consonants from a word
        return word.replaceAll("[^aeiouAEIOU]", "");
    }

    // Method 7
    private static String removeCommonLetters(String firstWord, String secondWord) {
        // Remove common letters from the first word
        for (char c : secondWord.toCharArray()) firstWord = firstWord.replace(Character.toString(c), "");
        return firstWord;
    }
}

