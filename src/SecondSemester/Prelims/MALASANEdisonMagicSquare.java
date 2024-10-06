package FirstYear.SecondSemester.Prelims;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/*
NAME: MALASAN, Edison M.
CLASS CODE: 9322A/B CS 112/112L
DATE: 31/01/2024
 */

/* SAMPLE OUTPUT
Magic Square Generator
Enter the desired size of the magic square: 25
The magic square may be too big or too small
Magic Square Generator
Enter the desired size of the magic square: NUM
Please input a valid integer.
Problem detected For input string: "NUM"
Magic Square Generator
Enter the desired size of the magic square: 24
The size must be an odd number.
Magic Square Generator
Enter the desired size of the magic square: 23
23 by 23 magic square
   278   303   328   353   378   403   428   453   478   503   528     1    26    51    76   101   126   151   176   201   226   251   276
   302   327   352   377   402   427   452   477   502   527    23    25    50    75   100   125   150   175   200   225   250   275   277
   326   351   376   401   426   451   476   501   526    22    24    49    74    99   124   149   174   199   224   249   274   299   301
   350   375   400   425   450   475   500   525    21    46    48    73    98   123   148   173   198   223   248   273   298   300   325
   374   399   424   449   474   499   524    20    45    47    72    97   122   147   172   197   222   247   272   297   322   324   349
   398   423   448   473   498   523    19    44    69    71    96   121   146   171   196   221   246   271   296   321   323   348   373
   422   447   472   497   522    18    43    68    70    95   120   145   170   195   220   245   270   295   320   345   347   372   397
   446   471   496   521    17    42    67    92    94   119   144   169   194   219   244   269   294   319   344   346   371   396   421
   470   495   520    16    41    66    91    93   118   143   168   193   218   243   268   293   318   343   368   370   395   420   445
   494   519    15    40    65    90   115   117   142   167   192   217   242   267   292   317   342   367   369   394   419   444   469
   518    14    39    64    89   114   116   141   166   191   216   241   266   291   316   341   366   391   393   418   443   468   493
    13    38    63    88   113   138   140   165   190   215   240   265   290   315   340   365   390   392   417   442   467   492   517
    37    62    87   112   137   139   164   189   214   239   264   289   314   339   364   389   414   416   441   466   491   516    12
    61    86   111   136   161   163   188   213   238   263   288   313   338   363   388   413   415   440   465   490   515    11    36
    85   110   135   160   162   187   212   237   262   287   312   337   362   387   412   437   439   464   489   514    10    35    60
   109   134   159   184   186   211   236   261   286   311   336   361   386   411   436   438   463   488   513     9    34    59    84
   133   158   183   185   210   235   260   285   310   335   360   385   410   435   460   462   487   512     8    33    58    83   108
   157   182   207   209   234   259   284   309   334   359   384   409   434   459   461   486   511     7    32    57    82   107   132
   181   206   208   233   258   283   308   333   358   383   408   433   458   483   485   510     6    31    56    81   106   131   156
   205   230   232   257   282   307   332   357   382   407   432   457   482   484   509     5    30    55    80   105   130   155   180
   229   231   256   281   306   331   356   381   406   431   456   481   506   508     4    29    54    79   104   129   154   179   204
   253   255   280   305   330   355   380   405   430   455   480   505   507     3    28    53    78   103   128   153   178   203   228
   254   279   304   329   354   379   404   429   454   479   504   529     2    27    52    77   102   127   152   177   202   227   252
 */

public class MALASANEdisonMagicSquare {
    public static void main(String[] args) {
        MALASANEdisonMagicSquare test;
        try {
            test = new MALASANEdisonMagicSquare();
            test.run();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        System.exit(0);
    } // end of main method
    // more codes here

    public void initializeArray(int[][] a){
        for (int row=0; row<a.length; row++){
            for (int col=0; col<a[row].length; col++)
                a[row][col] = 0;
        }
    }//end of method

    public int[][] generateMagicSquare(int size) {
        int[][] magicSquare = new int[size][size];
        initializeArray(magicSquare);

        int element = 1;
        int row = 0;
        int col = size / 2;

        magicSquare[row][col] = element;

        while (element < size*size) {
            element++;
            row--;
            col++;

            if (row < 0 && col > size - 1) {// out of bounds above
                row = row + 2;
                col = col - 1;
            }
            if (row < 0 ) {
                row = size - 1;
            }
            if (col > size - 1) {// out of bounds to the right
                col = 0;
            }
            if (magicSquare[row][col] != 0 ) {
                row = row + 2;
                col = col - 1;
            }
            magicSquare[row][col] = element;
        }

        return magicSquare;
    }//end of method

    public void run() throws Exception {
        BufferedReader kbd= new BufferedReader(new InputStreamReader(System.in));
        int size=0;
        boolean Input = false;

        while (!Input) { //while loop that keep asking for user input until the input is valid
            try {
                System.out.println("Magic Square Generator");
                System.out.print("Enter the desired size of the magic square: ");
                size = Integer.parseInt(kbd.readLine());

                if (size % 2 == 0) {
                    System.out.println("The size must be an odd number.");
                } else if (size < 3 || size >= 25) {
                    System.out.println("The magic square may be too big or too small");
                } else {
                    Input = true; // exit the loop if the input is valid
                    System.out.println(size + " by " + size + " magic square");
                    display(generateMagicSquare(size));
                }
            } catch (NumberFormatException e) {
                System.out.println("Please input a valid integer.");
                System.out.println("Problem detected " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading input. Please try again.");
                System.out.println("Problem detected "+ e.getMessage());
            }
        }

        try {
            kbd.close();
        } catch (IOException e) {
            e.getMessage();
        }
    }//end of method

    public void display(int[][] array){
        for (int r=0; r<array.length; r++){
            for (int c=0; c<array[r].length; c++){
                System.out.printf("%6d", array[r][c]);
            }
            System.out.println();
        }
    // more methods may be included if deemed necessary
    }
}// end of class