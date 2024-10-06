package FirstYear.SecondSemester.Prelims.Exercise5.Student;

// Example of a class that uses the Student Class (Reference Class)
// Put the source in the same package where the Student class is placed.

import java.util.Scanner;
public class StudentList {
    static Scanner keyboard = new Scanner(System.in);
    public static void main(String[] args) {
        StudentList myProgram;
        try {
            myProgram = new StudentList();
            myProgram.run();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        System.exit(0);
    } // end of main method

    public void run() {
        Student[] list;
        int number;
        number = readInteger("How many students will be listed? ",1,55);
//System.out.print("How many students will be listed? ");
//number = Integer.parseInt(keyboard.nextLine());
        list = new Student[number];
        System.out.println("Enter the student information.");
        for (int x = 0; x < list.length; x++) {
            System.out.println("For student " + (x + 1) + " :");
            list[x] = readStudent();
        }
        System.out.println();
        System.out.println("Unsorted List");
        showList(list);
        System.out.println();
        System.out.println("Sorted List");
        sortList(list);
        showList(list);
    }

    private void showList(Student[] studs) {
        for (int x = 0; x < studs.length; x++) {
            System.out.println(studs[x].toString());
        }
    }
    private Student readStudent() {
        System.out.print("first name: ");
        String f = keyboard.nextLine();
        System.out.print("middle name: ");
        String m = keyboard.nextLine();
        System.out.print("last name: ");
        String l = keyboard.nextLine();
        int a = readInteger("age: ",15,100);
//System.out.print("age: ");
//int a = Integer.parseInt(keyboard.nextLine());
        double g = readDouble("Grade Point Average: ", 65, 99);
//System.out.print("Grade Point Average: ");
//double g = Double.parseDouble(keyboard.nextLine());
        Student s = new Student(f, m, l, a, g);
        return s;
    }
    /* Note! Using the last name as the sort key is not sufficient
    for a realistic set of records.
    This method may need improvement */
    //EASY WAY TO IMPROVE THIS IS USING INSERTION SORT ALGORITHM
    private void sortList(Student[] s) {
        for (int x = 0; x < s.length - 1; x++) {
            Student key = s[x];
            int i = x - 1;

            while (i >= 0 && compareStudents(s[i], key) > 0) {
                s[i + 1] = s[i];
                x = i + 1;
            }
            s[i + 1] = key;
        }
    } // end of sortList method

    private int compareStudents(Student student1, Student student2) {
        int lNameCompare = student1.getLastName().compareToIgnoreCase(student2.getLastName());

        if (lNameCompare == 0) {
            return student1.getFirstName().compareToIgnoreCase(student2.getFirstName());
        }

        return lNameCompare;
    }// end of compare

    /**
     * Returns an integer read from the keyboard. The integer must be
     * in the range lowLimit to upLimit.
     */
    public int readInteger(String promptMessage, int lowLimit, int upLimit){
        Scanner scanner = new Scanner(System.in);
        int value = -1;
        boolean validValueRead = false;
        while( !validValueRead ) {
            try {
                System.out.print(promptMessage + ": ");
                value = Integer.parseInt(scanner.nextLine());
                if (value < lowLimit ){
                    System.out.println("You must enter an integer that is not lower than "+lowLimit+".");
                }
                else if (value > upLimit) {
                    System.out.println("You must enter an integer that is not greater than "+ upLimit+".");
                }
                else
                    validValueRead = true;
            } catch (NumberFormatException x){
                validValueRead = false;
                System.out.println("You may have entered an invalid integer.");
                System.out.println("Try again. ");
            } // end of catch
        } // end of while
        return value;
    } // end of readInteger method
    /**
     * Returns a floating point number of type double that is read
     * from the keyboard. The number must be
     * in the range lowLimit to upLimit.
     */
    public double readDouble(String promptMessage, double lowLimit, double upLimit){
        Scanner scanner = new Scanner(System.in);
        double value = 0;
        boolean validValueRead = false;
        while( !validValueRead) {
            try { System.out.print(promptMessage + ": ");
                value = Double.parseDouble(scanner.nextLine());
                if (value < lowLimit ){
                    System.out.println("You must enter an integer that is not lower than "+lowLimit+".");
                } else
                if (value > upLimit) {
                    System.out.println("You must enter an integer that is not greater than "+ upLimit+".");
                } else
                    validValueRead = true;

            } catch (NumberFormatException x){
                validValueRead = false;
                System.out.println("You may have entered an invalid value.");
                System.out.println("Try again. ");
            } // end of catch
        } // end of while
        return value;
    } // end of readDouble method
} // end of class
