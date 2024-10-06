package FirstYear.SecondSemester.Midterms.Exercise1;


public class SubInherit extends ConsInherit {
    public SubInherit(int i) { // this calls the first constructor
        super(i);                       // defined for ConsInherit...

// other constructor code here...

    }

    public SubInherit(boolean b) { // this calls the second constructor
        super(b); // defined for ConsInherit...

// other constructor code here...

    }
    public SubInherit(double j) { // this will not work since it will
        super(j);
    }                               // implicitly invoke the default
}                                       // constructor for ConsInherit, which
                                                // happens to be undefined...
