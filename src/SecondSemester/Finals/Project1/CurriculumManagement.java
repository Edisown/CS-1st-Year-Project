package FirstYear.SecondSemester.Finals.Project1;



import java.io.*;
import java.util.ArrayList;

public class CurriculumManagement implements CurriculumManager{
    private static final String fileName = "Files/Curriculum.txt";
    private static final ArrayList<Course> courses = new ArrayList<>();


    /**
     * Fills the Arraylist with Courses
     */
    @Override
    public void fillCurriculum() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null){
                String[] courseText = line.split(",(?!\\s)");
                Course course = readCourse(courseText);
                courses.add(course);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Reads the courses details in array of String and returns an object of Course
     * @param courseText the details of the course (units, title, course no.)
     * @return a new object of Course
     */
    private Course readCourse(String[] courseText) {
        byte year = Byte.parseByte(courseText[0]);
        String term = courseText[1];
        String courseNumber = courseText[2];
        String courseTitle = courseText[3];
        float units = Float.parseFloat(courseText[4]);

        if (courseText[5].equals("Not Yet Taken")){
            return new Course(year, term, courseNumber, courseTitle, units);
        } else {
            byte grade = Byte.parseByte(courseText[5]);
            return new Course(year, term, courseNumber, courseTitle, units, (grade));
        }
    }


    /**
     * @return the Arraylist of Courses
     */
    @Override
    public ArrayList<Course> getCurriculum() {
        return courses;
    }


    /**
     * edits the grades of the courses of a specific term of a year
     * @param grades the ArrayList of grades to be set
     * @param year the year of the course to be changed
     * @param term the term of the course to be changed
     * @throws ValueOutOfRangeException when the grade exceeds the maximum or the minimum value
     */
    @Override
    public void editGrade(ArrayList<Byte> grades, int year, String term) throws ValueOutOfRangeException {
        int count = 0;
        for (Course course : courses){
            if (course.getYear() == year && course.getTerm().equals(term)){
                byte grade = grades.get(count);
                if (grade == 0){
                    course.setGrade((byte) 0);
                } else if (notValid((float) grade, (byte) 65, (byte) 99)){
                    throw new ValueOutOfRangeException();
                } else {
                    course.setGrade(grade);
                }
                count++;
            }
        }
    }

    /**
     * @param number number to be checked
     * @param minimum lowest number allowed
     * @param maximum highest number allowed
     * @return true if the number is valid, otherwise false.
     */
    private boolean notValid(Float number, byte minimum, byte maximum) {
        return number > maximum || number < minimum;
    }


    /**
     * @param courseDetails the list of courses to be set
     * @param year the year of the course to be changed
     * @param term the term of the course to be changed
     * @throws ValueOutOfRangeException when the units of the course exceeds the limit
     */
    @Override
    public void editCourse(ArrayList<String[]> courseDetails, int year, String term) throws ValueOutOfRangeException {
        int count = 0;
        for (Course course : courses){
            if (course.getYear() == year && course.getTerm().equals(term)){
                if (notValid(Float.parseFloat(courseDetails.get(count)[2]), (byte) 1, (byte) 6)){
                    throw new ValueOutOfRangeException();
                }
                course.setCourseNumber(courseDetails.get(count)[0]);
                course.setDescriptiveTitle(courseDetails.get(count)[1]);
                course.setUnits(Float.parseFloat(courseDetails.get(count++)[2]));
            }
        }
    }


    /**
     * calculates the GPA of the student
     * @return the calculated GPA of the student
     */
    @Override
    public double calculateGPA() {
        double units = 0;
        double score = 0;
        for (Course course : courses){
            if (course.getGrade() == 0){
                continue;
            }
            score += course.getGrade() * course.getUnits();
            units += course.getUnits();
        }
        double average = score/units;
        String averageString = String.format("%.3f", average);
        return Double.parseDouble(averageString);
    }


    /**
     * Saves the changes made of the user in his Curriculum monitoring
     */
    @Override
    public void saveCurriculum() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))){
            for (Course course : courses){
                String grade = course.getGrade() + "";
                if (course.getGrade() == 0){
                    grade = "Not Yet Taken";
                }
                writer.write(course.getYear() + "," + course.getTerm() + "," + course.getCourseNumber() + "," +
                        course.getDescriptiveTitle() + "," + course.getUnits() + "," + grade + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void reset() {
        try (BufferedReader reader = new BufferedReader(new FileReader("Files/Original Curriculum.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter("Files/Curriculum.txt")))  {

            String line;
            while ((line = reader.readLine()) != null){
                writer.write(line + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        courses.clear();
        fillCurriculum();
    }

}





/**
 * user defined exception
 */
class ValueOutOfRangeException extends Exception{
    public ValueOutOfRangeException(){
        super();
    }
}
