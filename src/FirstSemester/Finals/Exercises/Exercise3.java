package FirstYear.FirstSemester.Finals.Exercises;

public class Exercise3 {
    public static void main(String[] args) {
        for (int i = 0; i<=1000; i++){
            if (isPalindrome(i)){
                System.out.println(i + " is a Palindrome Number");
            }
        }
    }
    public static boolean isPalindrome (int num){
        String numString = String.valueOf(num);
        int length = numString.length();
        for (int j = 0;j < length / 2; j++) {
            if (numString.charAt(j) != numString.charAt(length - 1 - j)) {
                return false;
            }
        }
        return true;
    }
}
