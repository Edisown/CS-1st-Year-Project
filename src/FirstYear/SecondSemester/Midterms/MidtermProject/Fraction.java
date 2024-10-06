package FirstYear.SecondSemester.Midterms.MidtermProject;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int wholeNumVal) {
        numerator = wholeNumVal;
        denominator = 1;
    }

    public Fraction(int whole, int numerator, int denominator) {
        this.numerator = (whole * denominator) + numerator;
        this.denominator = denominator;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    public void setDenominator(int denominator) {
        this.denominator = denominator;
    }

    public int getDenominator() {
        return denominator;
    }

    public String toString() {
        if (denominator == 1)
            return Integer.toString(numerator);
        else if(numerator == 0)
            return "0";
        return numerator + "/" + denominator;
    }

    public double toDouble() {

        return Double.parseDouble(String.format("%.2f", (double) numerator / denominator));
    }

    public Fraction add(Fraction other) {
        int newNumerator = (this.numerator * other.getDenominator()) + (other.getNumerator() * this.denominator);
        int newDenominator = this.denominator * other.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }//end of add


    public Fraction subtract(Fraction other) {
        int newNumerator = (this.numerator * other.getDenominator()) - (other.getNumerator() * this.denominator);
        int newDenominator = this.denominator * other.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }//end of subtraction


    public Fraction multiplyBy(Fraction other) {
        int newNumerator = this.numerator * other.getNumerator();
        int newDenominator = this.denominator * other.getDenominator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }//end of multiply


    public Fraction divideBy(Fraction other) {
        int newNumerator = this.numerator * other.getDenominator();
        int newDenominator = this.denominator * other.getNumerator();
        Fraction result = new Fraction(newNumerator, newDenominator);
        result.reduce();
        return result;
    }//end of division


    /**
     * Method use to reduce/simplify the fraction
     */
    public void reduce() {
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
}


