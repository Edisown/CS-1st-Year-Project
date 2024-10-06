package FirstYear.SecondSemester.Finals.Project1;

import java.util.ArrayList;

public interface CurriculumManager {
    void fillCurriculum();
    void saveCurriculum();

    ArrayList<Course> getCurriculum();
    void editGrade(ArrayList<Byte> grades, int year, String term) throws ValueOutOfRangeException;
    void editCourse(ArrayList<String[]> courseDetails, int year, String term) throws ValueOutOfRangeException;

    double calculateGPA();
    void reset();
}