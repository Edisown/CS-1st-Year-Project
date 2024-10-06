package FirstYear.SecondSemester.Finals.Project1;


public class Course {
    private byte year;
    private String term;
    private String courseNumber;
    private String descriptiveTitle;
    private float units;
    private byte grade;


    public Course(byte year, String term, String courseNumber, String descriptiveTitle, float units) {
        this.year = year;
        this.term = term;
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.units = units;
        grade = 0;
    }


    public Course(byte year, String term, String courseNumber, String descriptiveTitle, float units, byte grade) {
        this.year = year;
        this.term = term;
        this.courseNumber = courseNumber;
        this.descriptiveTitle = descriptiveTitle;
        this.units = units;
        this.grade = grade;

    }

    public byte getYear() {
        return year;
    }

    public void setYear(byte year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCourseNumber() {
        return courseNumber;
    }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getDescriptiveTitle() {
        return descriptiveTitle;
    }

    public void setDescriptiveTitle(String descriptiveTitle) {
        this.descriptiveTitle = descriptiveTitle;
    }

    public float getUnits() {
        return units;
    }

    public void setUnits(float units) {
        this.units = units;
    }

    public byte getGrade() {
        return grade;
    }

    public void setGrade(byte grade) {
        this.grade = grade;
    }
}
