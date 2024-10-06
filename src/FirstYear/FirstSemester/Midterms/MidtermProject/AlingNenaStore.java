package FirstYear.FirstSemester.Midterms.MidtermProject;

import javax.swing.JOptionPane;

public class AlingNenaStore {
    public static void main(String[] args) {

        String product;
        int quantity;
        double discount, ttlAmount, unitPrice, cash, ttlDiscount, change, ttlPayment;
        int check = 0;

        while (check == 0) {
            String inputStr = JOptionPane.showInputDialog(
                    "Choose your Item\n" +
                            "1. Eggs\n" +
                            "2. Milk\n" +
                            "3. Sardines\n" +
                            "4. Biscuit\n" +
                            "5. Exit\n" +
                            "Enter the number of the item:");

            if (inputStr == null) {
                System.exit(0); // Exit if the user cancels the input
            }

            product = "";
            try {
                int input = Integer.parseInt(inputStr);
                switch (input) {
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

            String quantityStr = JOptionPane.showInputDialog("Product: " + product + "\nQuantity:");
            if (quantityStr == null) {
                System.exit(0); // Exit if cancel
            }

            try {
                quantity = Integer.parseInt(quantityStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid quantity.");
                continue;
            }

            String cashStr = JOptionPane.showInputDialog("Cash Tendered:");
            if (cashStr == null) {
                System.exit(0); // Exit if cancel
            }

            try {
                cash = Double.parseDouble(cashStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid cash amount.");
                continue;
            }

            if (quantity >= 12) {
                ttlAmount = unitPrice * quantity;
                ttlDiscount = 0.10 * ttlAmount;
            } else {
                ttlAmount = unitPrice * quantity;
                ttlDiscount = 0;
            }
            ttlPayment = ttlAmount - ttlDiscount;
            change = cash - ttlPayment;

            JOptionPane.showMessageDialog(null,
                    "Product: " + product +
                            "\nYour Total Discount is: " + String.format("%.2f%% or %.2f Pesos", ttlDiscount * 100 / ttlAmount, ttlDiscount) +
                            "\nTotal Amount to be Paid: " + String.format("%.2f", ttlPayment) +
                            "\nYour Change: " + String.format("%.2f", change));

        }
    }
}