package FirstYear.SecondSemester.Midterms.MidtermProject2;

public abstract class Shape {
    private String name;
    protected int sides;
    public Shape(String n) {
        name = n;
    }
    public String toString() {
        return name + "with"  + sides + "sides. ";
    }
    public int getSides() {
        return sides;
    }
    // declaration of the abstract methods
    public abstract double area();
    public abstract double perimeter();
}
