package FirstYear.FirstSemester.Finals.Exercises;

public class Exercise1 {
    public static void main(String[] args) {
        for (int e = 1; e<=100; e++) {
            if (isEven(e)){
                System.out.println(e + " is an Even Number");
            }
        }
    }
    public static boolean isEven(int number){
        return number % 2 == 0;
    }
}
