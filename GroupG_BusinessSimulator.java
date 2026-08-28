public class GroupG_BusinessSimulator {

//Calculate the discounted subtotal for one item
    public static double calculateSubtotal(double price, int quantity, int itemNumber){

        double subtotal = price * quantity;

        // Novel: buy 3 or more and get 5% off
        if (itemNumber == 1 && quantity >= 3) {  
            subtotal = subtotal * 0.95;
        }

        //Textbooks have no discount
        else if (itemNumber == 2) {  
        }

        //Magazine: buy 5 or more and get UGX 1000 off
        else if (itemNumber == 3 && quantity >= 5) {
            subtotal = subtotal - 1000;
        }

        //Notebook: buy 10 or more and get 10% off
        else if (itemNumber == 4  && quantity >= 10) {
            subtotal = subtotal * 0.90;
        }

        return subtotal;

    }    

//Printing the itemised Receipt
    public static void printReceipt(String[] itemNames, int[] quantities, double[] subtotals) {

        System.out.println();
        System.out.println("\n==== RECEIPT ====");

        for (int i=0; i < itemNames.length; i++) {

            String discountMessage = "no discount";

            if (i == 0 && quantities[i] >= 3) {
                discountMessage = "5% discount applied";
            }
            else if (i == 0 && quantities[i] < 3) {
                discountMessage = "no discount - fewer than 3";
            }
            else if (i == 1) {
                discountMessage = "no discount deal for item";
            }
            else if (i == 2 && quantities[i] >= 5) {
                discountMessage = "UGX 1,000 discount applied";
            }
            else if (i == 2 && quantities[i] < 5) {
                discountMessage = "no discount - fewer than 5";
            }
            else if (i == 3 && quantities[i] >= 10) {
                discountMessage = "10% discount applied";
            }
            else if (i == 3 && quantities[i] < 10) {
                discountMessage = "no discount - fewer than 10";
            }
            

            System.out.printf("%s x%d = UGX %.2f (%s)%n", itemNames[i], quantities[i], subtotals[i], discountMessage);
        }
    }


    public static void main(String[] args){

//Store the four items and their prices using arrays

        String[] itemNames = {"Novel", "Textbook", "Magazine", "Notebook"};
        double[] prices = {15000.00, 45000.00, 5000.00, 2000.00};


        //Display the price list using a loop
        System.out.println("==== PAGETURNER BOOKSTORE ====");

        for (int i=0; i<itemNames.length; i++){
            System.out.printf("%d. %s UGX %.2f%n", i+1, itemNames[i], prices[i]);
        }

        //Customer quantities
        int qty1 = 2;
        int qty2 = 2;
        int qty3 = 4;
        int qty4 = 10;

        //Store quantities in an array to be processed by a loop
        int[] quantities = {qty1, qty2, qty3, qty4};

//Calculate the discounted subtotal for each item
        double[] subtotals = new double[itemNames.length];

        for (int i=0; i < itemNames.length; i++) {
            subtotals[i] = calculateSubtotal(prices[i], quantities[i], i+1);
        }

        //Add all four discounted subtotals to get the grand total
        double grandTotal = 0;
         for (int i=0; i < subtotals.length; i++) {
            grandTotal = grandTotal + subtotals[i];
         }

//Print the itemised receipt
         printReceipt(itemNames, quantities, subtotals);

         //Print the grand total
         System.out.println("---------------------------------------");
         System.out.printf("TOTAL = UGX %.2f%n", grandTotal);
    
    }

    

}
