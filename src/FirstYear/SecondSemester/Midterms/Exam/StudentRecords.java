package FirstYear.SecondSemester.Midterms.Exam;
/**
 A hypothetical student reference class
 **/
import java.io.*;
import java.util.*;

public class StudentRecords {
    public static void main(String[] args) {
        StudentRecords program;
        try {

            program = new StudentRecords();
            program.run();
        } catch (FileNotFoundException fileProblem){
            System.out.println("There is a problem with the input file");
            System.out.println(fileProblem.getMessage());
            System.out.println("Fix the problem and run again");
        } catch (Exception exception){
            exception.printStackTrace();
        }
        System.exit(0);
    } // end of main method


    public void run() throws Exception{
        int arraySize = countLines("inputfile1.txt");
        Student[] students = new Student[arraySize];
        populateStudentArray("inputfile1.txt", students);
        System.out.println("\n\nList of Students Sorted Based On Names ");
        showSortedStudentsBasedOnNames(students);
        System.out.println("\n\nSorted Students Based on Grades");
        Student[] sortedStudents = sortStudentArrayBasedOnGrades(students);
        showSortedStudentsBasedOnGrades(sortedStudents);
        printToFile(sortedStudents,"outputfile.txt");
        return;
    } // end of run method


    private int countLines(String filename) throws FileNotFoundException, Exception{
        int count = 0;
        Scanner scanner = new Scanner(new File(filename));
        while (scanner.hasNextLine()) {
            count += 1;
            scanner.nextLine();
        }
        scanner.close();
        return count;
    } // end of countLines method


    private void populateStudentArray(String filename, Student[] studArray) throws FileNotFoundException, Exception{
        Scanner inputRead = new Scanner(new File(filename));
        int index = 0;
        while (inputRead.hasNextLine()) {
            String lineOfText = inputRead.nextLine();
            String[] dataLine = lineOfText.split(",");
            if (dataLine.length == 4) {
                try {
                    Student stud = new Student(dataLine[0], dataLine[1], Integer.parseInt(dataLine[2]), Double.parseDouble(dataLine[3]));
                    studArray[index++] = stud;
                } catch (NumberFormatException ex) {
                    System.out.println("Error analyzing data: " + ex.getMessage());
                }
            } else {
                System.out.println("Invalid data format: " + lineOfText);
            }
        }
        inputRead.close();
    } // end of populateStudentArray method


    private double computeClassAverage(Student[] studArray) throws Exception{
        double average = 0;
        for (Student student : studArray) {
            average += student.getGrade();
        }
        average /= studArray.length;
        return average;
    } // end of computeClassAverage method


    /**
     Returns a sorted version of a copy of a given array of Student using grade as the sort key.
     The copy of the given array is sorted so that the original for of the given array is maintained.
     */
    private Student[] sortStudentArrayBasedOnGrades(Student[] studArray) throws Exception{
        Student[] sortedArray = copyStudentArray(studArray);

        for (int i = 1; i < sortedArray.length; i++) {
            Student key = sortedArray[i];
            int j = i - 1;
            while (j >= 0 && sortedArray[j].getGrade() > key.getGrade()) {
                sortedArray[j + 1] = sortedArray[j];
                j = j - 1;
            }
            sortedArray[j + 1] = key;
        }
        return sortedArray;
    } // end of sortStudentArrayBasedOnGrades method



    /**
     Returns a copy of an array of Student
     */
    private Student[] copyStudentArray(Student[] studArray) throws Exception{
        Student[] arrayCopy = new Student[studArray.length];
        for (int index = 0; index < studArray.length; index++) {
            Student stud = new Student(studArray[index].getIdNumber(), studArray[index].getName(), studArray[index].getRawScore(), studArray[index].getGrade());
            arrayCopy[index] = stud;
        }
        return arrayCopy;
    } // end of copyStudentArray method
    /**
     Prints a report in a text file based on the content of the Student array.
     */
    public void printToFile(Student[] studArray, String outputFilename) throws Exception{
        PrintWriter outputFile = new PrintWriter(new FileWriter(outputFilename));
        for (Student student : studArray){
            outputFile.println(student.getIdNumber() + "," + student.getName() + "," + student.getRawScore() + "," + student.getGrade());
        }
        outputFile.close();
    } // end of printToFile method




    private void showSortedStudentsBasedOnNames(Student[] studArray) throws Exception {
        System.out.printf("%-15s%-20s%-15s%-15s%-12s%n","ID Number","Name","Raw Score", "Grade","Remarks");
        System.out.printf("%-15s%-20s%-15s%-15s%-12s%n","______________","_______________","______________",
                "______________","______________");
        ArrayList<Student> arrangedStudents = new ArrayList<Student>();
        for (int index=0; index < studArray.length; index++){
            arrangedStudents.add(studArray[index]);
        }
        Collections.sort(arrangedStudents);
        for (int index=0; index < arrangedStudents.size(); index++){
            System.out.printf("%-15s%-20s%-15d%- 15.2f",arrangedStudents.get(index).getIdNumber(),arrangedStudents.get(index).getName(),arrangedStudents.get(index).getRawScore(),
                    arrangedStudents.get(index).getGrade());
            String remark = (arrangedStudents.get(index).getGrade()<75? "FAILED":"PASSED");
            System.out.printf("%-12s%n",remark);
        }
        double classAverage = computeClassAverage(studArray);
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-50s%-15.2f%n","Average of Grades = " , classAverage);
        return;
    } // end of showSortedStudentsBasedOnNames method


    private void showSortedStudentsBasedOnGrades(Student[] sortedArray) throws Exception {
        System.out.printf("%-15s%-20s%-15s%-15s%-12s%n","ID Number","Name","Raw Score", "Grade","Remarks");
        System.out.printf("%-15s%-20s%-15s%-15s%-12s%n","______________","_______________","______________",
                "______________","______________");
        for (int index=0; index < sortedArray.length; index++){
            System.out.printf("%-15s%-20s%-15d%- 15.2f",sortedArray[index].getIdNumber(),sortedArray[index].getName(),sortedArray[index].getRawScore(), sortedArray[index].getGrade());
            String remark = (sortedArray[index].getGrade()<75? "FAILED":"PASSED");
            System.out.printf("%-12s%n",remark);
        }
        double classAverage = computeClassAverage(sortedArray);
        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("%-50s%-15.2f%n","Average of Grades = " , classAverage);
        return;
    } // end of showSortedStudentsBasedOnGrades method
} // end of StudentRecords class
