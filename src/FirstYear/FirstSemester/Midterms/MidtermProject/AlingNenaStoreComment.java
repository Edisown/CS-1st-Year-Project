package FirstYear.FirstSemester.Midterms.MidtermProject;

import javax.swing.JOptionPane;

public class AlingNenaStoreComment {
    public static void main(String[] args) {

        // variables to store product info, quantities, amounts, and cash
        String product;
        int quantity;
        double unitPrice, cash, ttlAmount, ttlDiscount, change, ttlPayment;
        int check = 0;

        // Loop
        while (check == 0) {
            // display product options
            String inputStr = JOptionPane.showInputDialog(
                    "Choose your Item\n" +
                            "1. Eggs\n" +
                            "2. Milk\n" +
                            "3. Sardines\n" +
                            "4. Biscuit\n" +
                            "5. Exit\n" +
                            "Enter the number of the item:");


            if (inputStr == null) {
                System.exit(0); // Exit if cancel
            }

            // initialize product and unitPrice
            product = "";
            try {
                int input = Integer.parseInt(inputStr);
                switch (input) {
                    // assign product and unitPrice in every choosen item
                    case 1:
                        product = "Eggs";
                        unitPrice = 5.00;
                        break;

                    case 2:
                        product = "Milk";
                        unitPrice = 10.00;
                        break;

                    case 3:
                        product = "Sardines";
                        unitPrice = 10.00;
                        break;

                    case 4:
                        product = "Biscuit";
                        unitPrice = 7.50;
                        break;

                    case 5:
                        System.exit(0);

                    default:
                        JOptionPane.showMessageDialog(null, "Out of Range");
                        continue;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a number.");
                continue;
            }

            // Get quantity of the chosen product from the user
            String quantityStr = JOptionPane.showInputDialog("Product: " + product + "\nQuantity:");
            if (quantityStr == null) {
                System.exit(0); // Exit if cancel
            }

            // parse the input quantity and handle invalid input
            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid quantity.");
                continue;
            }

            // Get cash provided by the user for the purchase
            String cashStr = JOptionPane.showInputDialog("Cash Tendered:");
            if (cashStr == null) {
                System.exit(0); // Exit if cancel
            }

            // Parse the input cash and handle invalid input
            try {
                cash = Double.parseDouble(cashStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid cash amount.");
                continue;
            }

            // calculate total amount and discount based on the quantity purchased
            if (quantity >= 12) {
                ttlAmount = unitPrice * quantity;
                ttlDiscount = 0.10 * ttlAmount;
            } else {
                ttlAmount = unitPrice * quantity;
                ttlDiscount = 0;
            }
            ttlPayment = ttlAmount - ttlDiscount;
            change = cash - ttlPayment;

            // display the purchase details to the user
            JOptionPane.showMessageDialog(null,
                    "Product: " + product +
                            "\nYour Total Discount is: " + String.format("%.2f%% or %.2f Pesos", ttlDiscount * 100 / ttlAmount, ttlDiscount) +
                            "\nTotal Amount to be Paid: " + String.format("%.2f", ttlPayment) +
                            "\nYour Change: " + String.format("%.2f", change));

        }
    }
}
