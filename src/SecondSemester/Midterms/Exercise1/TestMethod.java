package FirstYear.SecondSemester.Midterms.Exercise1;


public class TestMethod {
    public static void main(String[] args) {
        SuperOverride sp;
        sp = new SuperOverride();
        sp.methodTwo(); // calls superclass methodTwo()...
        sp = new SubOverride();
        sp.methodTwo(); // calls subclass methodTwo()... note that the
    }                                              // same object variable (sp) is used in both
}
