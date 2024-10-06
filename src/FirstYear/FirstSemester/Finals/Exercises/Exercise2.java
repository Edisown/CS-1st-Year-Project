package FirstYear.FirstSemester.Finals.Exercises;

public class Exercise2 {
    public static void main(String[] args) {
        for (int i = 1; i<=100; i++){
          if (isPrime(i)) {
              System.out.println(i + " is a prime number.");
          }
        }
    }
    public static boolean isPrime(int num) {
        if (num<1) { // Numbers less than 1 are not prime
            return false;
        }
        if (num<2) { // Numbers less than 2 are not prime
            return false;
        }
        if (num == 9) {
            return true;
        }
        if (num % 2 == 0) {
            return false;
        }
        for (int j = 3; j <= Math.sqrt(num); j += 2){
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}
