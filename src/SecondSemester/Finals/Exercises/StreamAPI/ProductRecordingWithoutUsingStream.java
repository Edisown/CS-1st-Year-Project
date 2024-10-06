/*
Name: Malasan, Edison M.
Date: 05/05/2024


Sample Run:

List of Products
1076543 Acme Vacuum Cleaner 180.11
3756354 Nadir Washing Machine 178.97
1234567 Zenith Fridge 151.98
7876161 Zenith Tumble Drier 159.99

Products with unit price that is less than 170
1234567 Zenith Fridge 151.98
7876161 Zenith Tumble Drier 159.99

There are 2 items costing less than 170.

**/

package prog2.samcis.slu;
import java.lang.*;
import java.util.*;
public class ProductRecordingWithoutUsingStream {
    public static void main(String[] args){
        ProductRecordingWithoutUsingStream program;
        try {
            program = new ProductRecordingWithoutUsingStream();
            program.run();
        } catch (Exception x){
            x.printStackTrace();
        }
        System.exit(0);
    } // end of main
    public void run() throws Exception{
// Create a list of products
        List<Product> productList = new ArrayList<Product>();
        int counter = 0;
//Populate the list of products
        productList.add(new Product("1076543", "Acme", "Vacuum Cleaner", 180.11));

        productList.add(new Product("3756354", "Nadir", "Washing Machine", 178.97));
        productList.add(new Product("1234567", "Zenith", "Fridge", 151.98));
        productList.add(new Product("7876161", "Zenith", "Tumble Drier", 159.99));
        System.out.println("List of Products");
        for(Product p: productList){
            System.out.println(p);
        }
        System.out.println();
        System.out.println("Products with unit price that is less than 170");
        for (Product p: productList){
            if (p.getUnitPrice() < 170) {
                System.out.println(p);
                counter++;
            }
        }
        System.out.println("\nThere are " + counter + " items costing less than 170.");
        return;
    } // end of run
} // end of class
