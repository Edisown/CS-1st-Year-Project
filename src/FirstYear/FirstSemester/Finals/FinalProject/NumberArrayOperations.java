package FirstYear.FirstSemester.Finals.FinalProject;

import java.lang.*;
import java.util.*;

public class NumberArrayOperations {

    public static void main(String[] args) {
        Scanner kbd = new Scanner(System.in);
        int choice;
        int num;
        int a;
        int b;
        int bounds;

        System.out.println("""
                Welcome to our Java Program Collection
                Deponio, Drent
                Pajara, Paul
                Malasan, Edison
                Valdez, Byron
                Sabog, Jezreil
                Roxas, Jhorone
                Yuen, Ka Yue\s""");

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
                System.out.print("Input the number corresponding to your choice:");
                choice = Integer.parseInt(kbd.nextLine());
                System.out.println();

                switch (choice) {
                    case 1:
                        System.out.print("Input a valid number: ");
                        num = Integer.parseInt(kbd.nextLine());
                        System.out.println("\nThe number entered is " + isPerfectAbundantDeficient(num) + " Number");
                        break;

                    case 2:
                        System.out.print("Input a valid number: ");
                        num = Integer.parseInt(kbd.nextLine());
                        System.out.println("\nThe number entered is a " + isHappy(num) + " Number");
                        break;

                    case 3:
                        bounds = 100;
                        int[] newnum1 = randomArray(bounds);
                        System.out.println("Given Array: " + Arrays.toString(newnum1));

                        System.out.print("Please select an index from 0 to 9 to insert an element: ");
                        a = Integer.parseInt(kbd.nextLine());

                        System.out.print("Please enter the number you wish to insert: ");
                        b = Integer.parseInt(kbd.nextLine());

                        insertArray(a, b, newnum1);
                        displayArray(newnum1);
                        break;

                    case 4:
                        bounds = 50;
                        int[] newnum2 = randomArray(bounds);
                        System.out.println("Given Array: " + Arrays.toString(newnum2));

                        System.out.print("Please select an element to delete from the array: ");
                        a = Integer.parseInt(kbd.nextLine());

                        deleteArray(newnum2, a);
                        displayArray(newnum2);
                        break;

                    case 5:
                        System.out.print("Enter the size of the Multiplication Table: ");
                        int y = Integer.parseInt(kbd.nextLine());

                        int[][] data = multiplicationTable(y, y);
                        System.out.println();

                        for (int l = 0; l <= y; l++) {
                            System.out.print("[" + l + "]");
                        }

                        System.out.println();

                        for (int i = 0; i < data.length; i++) {
                            System.out.print("[" + (i + 1) + "]");
                            for (int j = 0; j < data[i].length; j++) {
                                System.out.printf("%2d ", data[i][j]);
                            }
                            System.out.println();
                        }
                        break;

                    case 6:
                        System.out.print("Enter a String (word): ");
                        String str = kbd.nextLine();
                        String result = removeConsonants(str);
                        System.out.println("String with removed consonants: " + result);
                        break;

                    case 7:
                        System.out.print("Enter the first string :");
                        String firstWord = kbd.nextLine();
                        System.out.print("Enter the second string :");
                        String secondWord = kbd.nextLine();
                        removeCommon(firstWord, secondWord);
                        break;

                    case 8:
                        System.out.println("Thank you for using the program. Good bye!");
                        System.exit(0);

                    default:
                        System.out.println("Invalid input");
                }
            } else {
                System.out.println("error");
            }
        }
    }



    // Determines if a number is Perfect, Abundant, or Deficient
    public static String isPerfectAbundantDeficient(int num) {
        if (num <= 1) {
            return "deficient";
        }

        int sum = 1;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                sum += i;
            }
        }

        if (sum == num) {
            return "Perfect";
        } else if (sum < num) {
            return "Deficient";
        } else {
            return "Abundant";
        }
    }



    // Determines if a number is a Happy Number
    public static String isHappy(int n) {
        int sum, remainder;

        while (n != 1 && n != 4) {
            sum = 0;
            while (n > 0) {
                remainder = n % 10;
                sum += remainder * remainder;
                n /= 10;
            }
            n = sum;
        }

        return (n == 1) ? "a Happy" : "not a Happy";
    }


    // Generates a random array with values bounded by the given limit
    private static int[] randomArray(int bounds) {
        Random random = new Random();
        int[] newArray = new int[10];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = random.nextInt(bounds);
        }
        return newArray;
    }


    // Displays the contents of an array
    private static void displayArray(int[] arr) {
        System.out.println("Updated Array: " + Arrays.toString(arr));
    }


    // Inserts an element at a specific index in an array
    private static void insertArray(int pointer, int newValue, int[] num) {
        if (pointer < 0 || pointer > num.length) {
            System.out.println("Index out of range. Cannot insert element.");
            return;
        }

        for (int i = num.length - 1; i > pointer; i--) {
            num[i] = num[i - 1];
        }

        num[pointer] = newValue;
    }


    // Deletes an element from an array
    private static void deleteArray(int[] newnum2, int a) {
        boolean dupe = false;

        for (int i = 0; i < newnum2.length; i++) {
            if (newnum2[i] == a) {
                dupe = true;
                for (int j = i; j < newnum2.length - 1; j++) {
                    newnum2[j] = newnum2[j + 1];
                }
                newnum2[newnum2.length - 1] = 0;
                i--;
            }
        }

        if (!dupe) {
            System.out.println("Element not found. Cannot delete.");
        }
    }


    // Generates a multiplication table with the specified dimensions
    public static int[][] multiplicationTable(int r, int c) {
        int[][] table = new int[r][c];

        for (int row = 0; row < table.length; row++) {
            for (int column = 0; column < table[row].length; column++) {
                table[row][column] = (row + 1) * (column + 1);
            }
        }

        return table;
    }


    // Removes consonants from a given string
    public static String removeConsonants(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (isVowel(ch) || Character.isWhitespace(ch)) {
                result += ch;
            }
        }
        return result;
    }


    // Checks if a character is a vowel
    public static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }


    // Removes characters from the first string that are also in the second string
    private static void removeCommon(String firstWord, String secondWord) {
        String result = "";

        for (int i = 0; i < firstWord.length(); i++) {
            char currentChar = firstWord.charAt(i);
            if (secondWord.indexOf(currentChar) == -1) {
                result += currentChar;
            }
        }

        System.out.println("\nThe remaining letters in the first word is/are: " + result);
    }
}
