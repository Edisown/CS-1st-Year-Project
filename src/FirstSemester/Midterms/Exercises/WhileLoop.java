package FirstYear.FirstSemester.Midterms.Exercises;

public class WhileLoop {
        public static void main(String[] args){
            for (int i = 5; i > 0; i--){ //row
                for (int j = 1; j <= 5; j++){ //column
                    if (j < i){
                        System.out.print("  ");
                    } else {
                        System.out.print(" " + j);
                    }
                }
                System.out.println();
            }
        }
    }
