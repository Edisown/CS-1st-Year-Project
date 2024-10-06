package FirstYear.SecondSemester.Midterms.Exercise1;


/**
 * Executable class demonstrating the usage of the Scholar class
 */
public class SampleClass {
    public static void main(String[] args) {
        SampleClass program;
        try{
            program = new SampleClass();
            program.run();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        System.exit(0);
    }

    /**
     * Main Control flow of the program
     */
    public void run(){
        // create a Scholar instance using the default constructor
        Scholar scholar1 = new Scholar();
        System.out.println(scholar1.toString());

        // create a Scholar instance with a specified scholarship description
        Scholar scholar2 = new Scholar("DOST Scholar");
        System.out.println(scholar2.toString());

        // create a Scholar instance with specified attributes, including scholarship description
        Scholar scholar3 = new Scholar("John Doe","BSIT",(byte) 2, "SSS scholar");
        System.out.println(scholar3.toString());
    }// end of main method
}// end of class
