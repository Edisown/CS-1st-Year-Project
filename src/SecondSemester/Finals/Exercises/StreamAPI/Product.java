
/*
Name: Malasan, Edison M.
Date: 05/05/2024
**/
package prog2.samcis.slu;
public class Product implements Comparable<Product>{
    private String stockNumber;
    private String manufacturer;
    private String itemName;
    private double unitPrice;
    public Product(){
        stockNumber = "";
        manufacturer = "";
        itemName = "";
        unitPrice = 0;
    }
    public Product(String s1, String s2, String s3, double p){
        this.stockNumber = s1;
        this.manufacturer = s2;

        this.itemName = s3;
        this.unitPrice = p;
    }
    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }
    public void setManufacturer(String s){
        this.manufacturer = s;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public String getStockNumber(){
        return stockNumber;
    }
    public String getManufacturer() {
        return manufacturer;
    }
    public String getItemName() {
        return itemName;
    }
    public double getUnitPrice() {
        return unitPrice;

    }
    @Override
    public String toString(){
        return stockNumber + " " + manufacturer + " " + itemName + " " + unitPrice;
    }
    @Override
    public int compareTo(Product other) {
        return stockNumber.compareTo(other.getStockNumber());
    }
    public boolean equals(Object another){
        return this.toString().equals(((Product) another).toString());
    }
} // end of class