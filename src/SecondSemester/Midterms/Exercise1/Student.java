package FirstYear.SecondSemester.Midterms.Exercise1;

public class Student {
    private String name;
    private String program;
    private byte yearLevel;


    /** Default Constructor
     * constructs a student with name Juan Delacruz,
     * program BSCS, year level 1;
     * */
    public Student(){
        name = "Juan Delacruz";
        program = "BSCS";
        yearLevel = (byte) 1;
    }


    /**
     * constructor that allows creating a student with specification
     *
     * @param name
     * @param p
     * @param y
     */
    public Student(String name, String p, byte y ){
        this.name = name;
        this.program = p;
        this.yearLevel = y;
    }


    /**
     * set the name of the student
     *
     * @param n The name to set
     */
    public void setName(String n){
        this.name = n;
    }


    /**
     * set the program in which the student is enrolled
     *
     * @param p The program to set
     */
    public void setProgram(String p){
        this.program = p;
    }


    /**
     * set the year level of the student
     *
     * @param b The year level to set
     */
    public void setYearLevel(byte b){
        this.yearLevel = b;
    }


    /**
     * get the name of the student
     *
     * @return The name of the student
     */
    public String getName(){
        return name;

    }


    /**
     * get the program in which the student is enrolled
     *
     * @return The program of the student
     */
    public String getProgram(){
        return program;
    }


    /**
     * get the year level of the student
     *
     * @return The year level of the student
     */
    public byte getYearLevel(){
        return yearLevel;
    }


    /**
     * returns a string representation of the student's specification
     *
     * @return name, program, yearLevel
     */
    public String toString(){
        return ("Name = "+name + "\nProgram = "+program + "\nYear Level = "+ yearLevel);
    }
}//end of class