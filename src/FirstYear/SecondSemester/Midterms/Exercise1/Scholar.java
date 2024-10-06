package FirstYear.SecondSemester.Midterms.Exercise1;

/**
 * Scholar class represents a student with an additional attribute for scholarship information
 * inheriting from the Student class.
 */
public class Scholar extends Student {
    private String scholarshipDescription;


    /**
     * default constructor for Scholar class, sets default values and initializes the scholarship specifications
     * default values: name = "Juan Delacruz", program = "BSCS", year level = 1, scholarship = "Working Scholar"
     */
    public Scholar(){
        super(); // calls the default constructor of the parent class (Student)
        scholarshipDescription = "Working Scholar";
    }


    /**
     * constructor for Scholar that allows setting the scholarship description
     * default values: name = "Juan Delacruz", program = "BSCS", year level = 1
     *
     * @param scholarshipDescription description of scholarship
     */
    public Scholar(String scholarshipDescription){
        super();
        this.scholarshipDescription = scholarshipDescription;
    }


    /**
     * Parameterized constructor for Scholar that allows setting all attributes including scholarship.
     *
     * @param n name of the scholar
     * @param p program in which the scholar is enrolled
     * @param y year level of the scholar
     * @param d description of the scholarship
     */
    public Scholar(String n, String p, byte y, String d){
        super(n,p,y); // calls the parameter of parent constructor of Student Class (Student)
        scholarshipDescription = d;
    }



    /**
     * set scholarship description for the scholar
     *
     * @param d
     */
    public void setScholarshipDescription(String d){

        this.scholarshipDescription = d;
    }


    /**
     * get scholarship description of the scholar.
     *
     * @return the description of the schoolarship
     */
    public String getScholarshipDescription(){

        return scholarshipDescription;
    }


    /**
     * return a string representation of the scholar's information, including scholarship details
     *
     * @return name, program, year level, and scholarship description.
     */
    public String toString(){

        return (super.toString() + "\nScholarship Name = " + scholarshipDescription);
    }
}//end of class
