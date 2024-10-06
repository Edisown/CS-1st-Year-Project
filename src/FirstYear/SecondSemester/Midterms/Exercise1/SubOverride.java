package FirstYear.SecondSemester.Midterms.Exercise1;

public class SubOverride extends SuperOverride {
    public void methodTwo() { // this overrides methodTwo() of the superclass...

// note that this is less restrictive (public
// here vis­à­vis protected in the superclass)...

        System.out.println("methodTwo from subclass...");
    }
    // this will be invalid, since the accessibility of the overriding method is
        // more restrictive (i.e., from public to private)...
    // private void methodOne() {}
    public void methodThree(int i) { // this method is overloaded across classes...

        System.out.println("methodThree from subclass...");
    }
}
