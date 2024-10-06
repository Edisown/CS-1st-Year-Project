package FirstYear.SecondSemester.Midterms.MidtermProject2;

public class Triangle extends Shape {
    private double side1;
    private double side2;
    private double side3;



    public Triangle(String name, double s1, double s2, double s3) {
        super(name);
        side1 = s1;
        side2 = s2;
        side3 = s3;
    }

    @Override
    public double area() {
        double p = (side1 + side2 + side3) / 2;
        return Math.sqrt(p * (p - side1) * (p - side2) * (p - side3));
    }

    @Override
    public double perimeter() {
        return side1 + side2 + side3;
    }
}
