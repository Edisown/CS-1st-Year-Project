/*
Name: Malasan, Edison M.
Date: 05/05/2024


Sample Run:

1. List of Products
1076543 Acme Vacuum Cleaner 180.11
3756354 Nadir Washing Machine 178.97
1234567 Zenith Fridge 151.98
7876161 Zenith Tumble Drier 159.99

2. List of Products
1076543 Acme Vacuum Cleaner 180.11
3756354 Nadir Washing Machine 178.97
1234567 Zenith Fridge 151.98
7876161 Zenith Tumble Drier 159.99


3. Products with unit price that is less than 170
1234567 Zenith Fridge 151.98
7876161 Zenith Tumble Drier 159.99

4. Products with unit price that is greater than 170
1076543 Acme Vacuum Cleaner 180.11
3756354 Nadir Washing Machine 178.97

There are 2 items costing less than 170.


**/
package prog2.samcis.slu;
import java.util.ArrayList;
import java.util.List;
public class ProductRecordingUsingStream {
    public static void main(String[] args){
        ProductRecordingUsingStream program;
        try {
            program = new ProductRecordingUsingStream();
            program.run();
        } catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    } // end of main
    public void run() throws Exception{
// Create a list of products
        List<Product> productList = new ArrayList<Product>();

//Populate the list of products
        productList.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));
        productList.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
        productList.add(new Product("1234567", "Zenith", "Fridge", 151.98));
        productList.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));
// Display all items using a stream
        /*
         * Obtain a stream from the ArrayList
         * Apply the forEach terminal operation to the stream
         */
        System.out.println("1. List of Products");
        productList.stream()
                .forEach(product -> System.out.println(product));
        System.out.println("\n2. List of Products");
        productList.stream()
                .forEach(System.out::println);
/*
Note that for forEach(product -> System.out.println(product))
may be written as by applying method reference as parameter.
Hence,
forEach(System.out:: println)
*/
//Print a blank line
        System.out.println();

// Filter the list to display products with costs that are less than 170
        /* Obtain a stream from the ArrayList
         * Apply the filter intermediate operation to the stream
         * Apply the forEach terminal operation to the result of the filter operation
         * */
        System.out.println("\n3. Products with unit price that is less than 170");
        productList.stream()
                .filter(p -> p.getUnitPrice()<170)
                .forEach(p -> System.out.println(p));
        System.out.println("\n4. Products with unit price that is greater than 170");
        productList.stream()
                .filter(p -> p.getUnitPrice()>170)
                .forEach(System.out::println);
//Count items with costs that are less than 170
/* Obtain a stream from the ArrayList
* Apply the filter intermediate operation to the stream
* Apply the count terminal operation to the result of filter
* Assign the result of the count operation to counter
* (Note that the return type of terminal operation count()
is long.
* Hence, the type casting is needed if the result is
assigned to an int variable)
* */
        int counter = (int) productList.stream()
                .filter(p -> p.getUnitPrice() <170)
                .count();
        System.out.println("\nThere are " + counter + " items costing less than 170.");
        return;
    } // end of run
} // end of class
