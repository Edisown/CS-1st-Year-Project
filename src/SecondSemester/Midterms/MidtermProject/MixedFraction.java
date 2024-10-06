package FirstYear.SecondSemester.Midterms.MidtermProject;

public class MixedFraction extends Fraction {
    private int whole;


    public MixedFraction(){
        this.whole = 0;
    }

    public MixedFraction(int whole, Fraction fraction) {
        super(whole, fraction.getNumerator(), fraction.getDenominator());
        this.whole = whole;
    }

    public MixedFraction(int whole, int numerator, int denominator){
        super(whole, numerator, denominator);
        this.whole = whole;
    }

    public MixedFraction(Fraction fraction){
        super(fraction.getNumerator(), fraction.getDenominator());
        this.whole = fraction.getNumerator() / fraction.getDenominator();
    }

    //SETTERS

    public void setWholePart(int whole) {
        this.whole = whole;
    }

    public void setFractionPart(Fraction fraction) {
        setNumerator(fraction.getNumerator());
        setDenominator(fraction.getDenominator());
    }

    //GETTERS
    public int getWhole() {
        return whole;
    }

    public Fraction getFractionPart() {
        return new Fraction(getNumerator() % getDenominator(), getDenominator());
    }

    //Converting Fraction
    public Fraction toFraction(){
        return new Fraction((whole * getDenominator()) + getNumerator(), getDenominator());
    }

    //OPERATIONS


    @Override
    public MixedFraction add(Fraction other) {
        Fraction resultFraction = super.add(other);
        return new MixedFraction(resultFraction);
    }

    public MixedFraction subtract(Fraction other) {
        Fraction resultFraction = super.subtract(other);
        return new MixedFraction(resultFraction);
    }

    public MixedFraction multiplyBy(Fraction other) {
        Fraction resultFraction = super.multiplyBy(other);
        return new MixedFraction(resultFraction);
    }

    public MixedFraction divideBy(Fraction other) {
        Fraction resultFraction = super.multiplyBy(other);
        return new MixedFraction(resultFraction);
    }

    @Override
    public String toString() {
        int remainder = super.getNumerator() % super.getDenominator();
        if (remainder == 0)
            return Integer.toString(whole);
        else if (whole == 0)
            return super.toString();
        else
        return whole + " " + super.toString();
    }

    @Override
    public double toDouble() {
        return whole + super.toDouble();
    }
}
