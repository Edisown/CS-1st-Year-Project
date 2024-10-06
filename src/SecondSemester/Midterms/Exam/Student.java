package FirstYear.SecondSemester.Midterms.Exam;

/**
 A hypothetical student reference class
 * */

public class Student implements Comparable<Student> {
    private String idNumber;
    private String name;
    private int rawScore;
    private double grade;

    /**
     Constructs a student with id number of 2240000,
     name Delacruz John, raw score 0 and grade 65
     */
    public Student(){
        this.idNumber="2240000";
        this.name="Delacruz John";
        this.rawScore=0;
        this.grade=65;
    }

    /**
     Constructs a student with a given id number,
     name, raw score and grade.
     */
    public Student(String idNumber, String name, int rawScore, double grade) {
        this.idNumber = idNumber;
        this.name = name;
        this.rawScore = rawScore;
        this.grade = grade;
    }

    /**
     Sets the id number of this student to a given id number
     */
    public void setIdNumber(String idNumber){
        this.idNumber = idNumber;
    }

    /**
     Sets the name of this student to a given name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     Sets the raw score of this student to a given raw score
     */
    public void setRawScore(int rawScore){
        this.rawScore = rawScore;
    }

    /**
     Sets the grade of this student to a given grade
     */
    public void setGrade(double grade){
        this.grade = grade;
    }

    /**
     Returns a comma separated string that reveals the id number,
     name, raw score and grade of this student
     */
    public String toString(){
        return idNumber+","+name+","+rawScore+","+grade;
    }

    /**
     returns true if this student has the same id number, name,
     raw score and grade as another student, returns false otherwise.
     */
    public boolean equals (Student another){
        return this.toString().equals(another.toString());
    }


    /**
     returns the id number of this student
     */
    public String getIdNumber(){
        return idNumber;
    }

    /**
     returns the name of this student
     */
    public String getName(){
        return name;
    }

    /**
     returns the raw score of this student
     */
    public int getRawScore(){
        return rawScore;
    }

    /**
     returns the grade of this student
     */
    public double getGrade(){
        return grade;
    }

    /**
     Returns 1 if the name of this student is lexicographically
     after the name of another student, returns -1 if the name of this
     student is lexicographically afetr the name of another student,
     returns 0 if the name of this student is lexicographically the same
     as the name of another student.
     */
    public int compareTo(Student another){
        if (another == null)
            return 1;
        return (this.name.compareTo(another.getName()));
    }
} // end of student class