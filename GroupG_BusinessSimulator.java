public class GroupG_BusinessSimulator {

    // A basic class representing one item in the bookstore
    static class Item {
        String name;
        double price;
        int quantity;
        int itemNumber;   // 1 = Novel, 2 = Textbook, 3 = Magazine, 4 = Notebook

        // Constructor - runs when a new Item object is created
        public Item(String name, double price, int quantity, int itemNumber) {
            this.name = name;
            this.price = price;
            this.quantity = quantity;
            this.itemNumber = itemNumber;
        }

        // Calculate the discounted subtotal for this item
        public double calculateSubtotal() {
            double subtotal = price * quantity;

            // Novel: buy 3 or more and get 5% off
            if (itemNumber == 1 && quantity >= 3) {
                subtotal = subtotal * 0.95;
            }

            // Textbooks have no discount
            else if (itemNumber == 2) {
            }

            // Magazine: buy 5 or more and get UGX 1000 off
            else if (itemNumber == 3 && quantity >= 5) {
                subtotal = subtotal - 1000;
            }

            // Notebook: buy 10 or more and get 10% off
            else if (itemNumber == 4 && quantity >= 10) {
                subtotal = subtotal * 0.90;
            }

            return subtotal;
        }

        // Work out the discount message for this item
        public String getDiscountMessage() {
            String discountMessage = "no discount";

            if (itemNumber == 1 && quantity >= 3) {
                discountMessage = "5% discount applied";
            } else if (itemNumber == 1 && quantity < 3) {
                discountMessage = "no discount - fewer than 3";
            } else if (itemNumber == 2) {
                discountMessage = "no discount deal for item";
            } else if (itemNumber == 3 && quantity >= 5) {
                discountMessage = "UGX 1,000 discount applied";
            } else if (itemNumber == 3 && quantity < 5) {
                discountMessage = "no discount - fewer than 5";
            } else if (itemNumber == 4 && quantity >= 10) {
                discountMessage = "10% discount applied";
            } else if (itemNumber == 4 && quantity < 10) {
                discountMessage = "no discount - fewer than 10";
            }

            return discountMessage;
        }
    }

    // Printing the itemised Receipt
    public static void printReceipt(Item[] items, double[] subtotals) {

        System.out.println();
        System.out.println("\n==== RECEIPT ====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%s x%d = UGX %.2f (%s)%n",
                    items[i].name, items[i].quantity, subtotals[i], items[i].getDiscountMessage());
        }
    }

    public static void main(String[] args) {

        // Store the four items and their prices/quantities as objects
        Item[] items = {
                new Item("Novel", 15000.00, 2, 1),
                new Item("Textbook", 45000.00, 2, 2),
                new Item("Magazine", 5000.00, 4, 3),
                new Item("Notebook", 2000.00, 10, 4)
        };

        // Display the price list using a loop
        System.out.println("==== PAGETURNER BOOKSTORE ====");

        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %s UGX %.2f%n", i + 1, items[i].name, items[i].price);
        }

        // Calculate the discounted subtotal for each item
        double[] subtotals = new double[items.length];

        for (int i = 0; i < items.length; i++) {
            subtotals[i] = items[i].calculateSubtotal();
        }

        // Add all four discounted subtotals to get the grand total
        double grandTotal = 0;
        for (int i = 0; i < subtotals.length; i++) {
            grandTotal = grandTotal + subtotals[i];
        }

        // Print the itemised receipt
        printReceipt(items, subtotals);

        // Print the grand total
        System.out.println("---------------------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", grandTotal);
    }
}