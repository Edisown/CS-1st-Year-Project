package FirstYear.SecondSemester.Prelims.Exercise5.CourseEnrollment;

public class CourseEnrollment {
    private String firstName;
    private String midName;
    private String lastName;
    private int studentID;
    private String courseCode;
    private String courseName;


    /**
     *Constructs a student named Edison M. Malasan, 2245504 STUDENT ID enrolled in Course CS112 Computer Programming 2
     */
    public CourseEnrollment() {
        firstName = "Edison";
        midName = "M.";
        lastName = "Malasan";
        studentID = 9999999;
        courseCode = "CS112";
        courseName = "Computer Programming 2";
    }

    /**
     * Constructs a student with name studentName, studentID, courseCode, courseName
     * and grade point average gpa.
     */
    public  CourseEnrollment(String firstName, String midName, String lastName, String courseCode, String courseName, int studentID) {
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.studentID = studentID;
        this.courseCode = courseCode;
        this.courseName = courseName;
    }

    //GETTERS
    /**
     *Returns the name of the student
     */
    public String getFirstName() {

        return firstName;
    }// end


    /**
     *Returns the mid name of the student
     */
    public String getMidName() {

        return midName;
    }// end


    /**
     *Returns the last name of the student
     */
    public String getLastName() {

        return lastName;
    } // end


    /**
     *Returns the id number of the student
     */
    public int getStudentID() {
        return studentID;
    }


    /**
     *Returns the course code of the student
     */
    public String getCourseCode() {

        return courseCode;
    }


    /**
     *Returns the course name
     */
    public String getCourseName() {

        return courseName;
    }


    //SETTERS
    /**
     * Sets the firstName to firstName
     */
    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }


    /**
     * Sets the midName to midName
     */
    public void setMidName(String midName) {
        this.midName = midName;
    }


    /**
     * Sets the lastName to lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    /**
     * Sets the studentID to studentID
     */
    public void setStudentID(int studentID) {

        this.studentID = studentID;
    }


    /**
     * Sets the courseCode to courseCode
     */
    public void setCourseCode(String courseCode) {

        this.courseCode = courseCode;
    }


    /**
     * Sets the courseName to courseName
     */
    public void setCourseName(String courseName) {

        this.courseName = courseName;
    }


    /**
     * Returns a string showing the Student Name, ID, Course Code and Course Name
     */
    public String toString() {

        return (lastName + " " + firstName + " " + midName + " " + studentID + " " + courseCode + " " + courseName);
    }


    /** Improve part
     *  if other is null then the entire  expression will become false because it's a null
     * the firstName.equalsIgnoreCase(other.getFirstName()) do is that it compares the firstName to the current student ignoring case if equal it evaluates to true if not then false.
     */
    public boolean equals(CourseEnrollment dup) {
        boolean d;

        d = (dup !=null) && firstName.equalsIgnoreCase(dup.getFirstName());

        return d;
    }
}
