package FirstYear.SecondSemester.Prelims.PrelimsProject;

public class Fraction {
    private int numerator;
    private int denominator;


    /**
    * Default constructor initializing the fraction to 0/1
     */
    public Fraction() {
        numerator = 0;
        denominator = 1;
    }


    /**
     *  parameter constructor intializing the fraction with given numerator and denominator.
     *
     * @param numerator numerator of the fraction
     * @param denominator denomator of the fraction
     */
    public Fraction (int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }


    /**
     * set the numerator of the fraction
     *
     * @param numerator new numerator value
     */
    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }


    /**
     * set the denominator of the fraction
     *
     * @param denominator new fraction denominator
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        } else {
            System.out.println("Error! Denominator cannot be zero.");
        }
    }


    /**
     * get the numerator of the fraction
     *
     * @return the numerator
     */
    public int getNumerator() {

        return numerator;
    }


    /**
     * get the denominator of the fraction
     *
     * @return the denominator
     */
    public int getDenominator() {

        return denominator;
    }


    /**
     * return a string representing the fraction in the form of "numerator/denominator"
     *
     * @return String representation of the fraction
     */
    public String toString() {

        return (numerator + "/" + denominator);
    }


    /**
     * return a decimal value of the fraction
     *
     * @return double/decimal form of numerator / numerator
     */
    public double toDouble() {

        return ( (double) numerator/denominator) ;
    }


    //----------------------------OPERATIONS--------------------------//

    /**
     * Method use to add two fractions
     *
     * @param secondFraction the fraction to be added
     * @return the sum of the fractions
     */
    public Fraction add(Fraction secondFraction) {
        int newNumerator = (this.numerator * secondFraction.getDenominator()) + (secondFraction.getNumerator() * this.denominator);
        int newDenominator = this.denominator * secondFraction.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }//end of add


    /**
     * Method use to subtract two fractions
     *
     * @param secondFraction the fraction to be subtracted
     * @return the difference of the fractions
     */
    public  Fraction subtraction(Fraction secondFraction){
        int newNumerator = (this.numerator * secondFraction.getDenominator()) - (secondFraction.getNumerator() * this.denominator);
        int newDenominator = this.denominator * secondFraction.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }//end of subtraction


    /**
     * Method use to multiply two fractions
     *
     * @param secondFraction the fraction to be multiplied
     * @return the product of the fractions
     */
    public  Fraction multiply(Fraction secondFraction){
        int newNumerator = this.numerator * secondFraction.getNumerator();
        int newDenominator = this.denominator * secondFraction.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }//end of multiply


    /**
     * Method use to divide two fractions
     *
     * @param secondFraction the fraction to be divided
     * @return the quotient of the  fractions
     */
    public Fraction division(Fraction secondFraction){
        int newNumerator = this.numerator * secondFraction.getDenominator();
        int newDenominator = this.denominator * secondFraction.getNumerator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        return result;
    }//end of division


    /**
     * Method use to reduce/simplify the fraction
     */
    public void reduceFraction() {
        int numerator = Math.abs(this.numerator);
        int denominator = Math.abs(this.denominator);

        int gcd = computeGCD(numerator, denominator);
        this.numerator /= gcd;
        this.denominator /= gcd;
    }//end of reduceFraction


    /**
     * Method use to compute the gcd of two numbeers using the Euclidean algorithm.
     *
     * @param numerator
     * @param denominator
     * @return the gcd of the two numbers.
     */
    public int computeGCD(int numerator, int denominator) {
        if (denominator == 0) {
            return numerator;
        }
        return computeGCD(denominator, numerator % denominator);
    }//end of computeGCD
}// end of Reference class