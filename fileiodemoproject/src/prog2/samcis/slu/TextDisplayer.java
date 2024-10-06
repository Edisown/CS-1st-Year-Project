/**
 Name: Malasan, Edison M.
 Date: 21/03/2024
 Class Code, Course Number and Schedule: 9322 A/B - (A)12:30 - 1:30 / (B)3:00 - 4:30
 */
package prog2.samcis.slu;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class TextDisplayer {
    public static void main(String[] args) {
        TextDisplayer program;
        try{
            program = new TextDisplayer();
            program.run();
        } catch (FileNotFoundException exception1) {
            System.out.println("The data file does not exist.");
        } catch (Exception exception2){
            exception2.printStackTrace();
        }
        System.exit(0);
    }
    public void run() throws FileNotFoundException, Exception{
        String lineOfText="";
        int count = 0;
        Scanner keyboard = new Scanner(System.in);
        Scanner fileReader = new Scanner(new File("samplefile1.txt"));
        while (fileReader.hasNextLine()) {
            count += 1;
            lineOfText = fileReader.nextLine();
            System.out.println("Line "+ count + " : "+ lineOfText);
            System.out.println("Press enter to continue...");
            String spaceChar = keyboard.nextLine();
        }
        fileReader.close();
    }
}
