public class Main {

    public static void main(String[] args) {
        Item[] items = {
            new PercentDiscountItem("Novel", 15000.00, 3, 5),
            new NoDiscountItem("Textbook", 45000.00),
            new FlatDiscountItem("Magazine", 5000.00, 5, 1000),
            new PercentDiscountItem("Notebook", 2000.00, 10, 10)
        };
        
        int[] quantities = {2, 2, 4, 10};

        System.out.println("==== PAGETURNER BOOKSTORE ====");
        for (int i = 0; i < items.length; i++) {
            System.out.printf("%d. %s UGX %.2f%n", i + 1, items[i].getName(), items[i].getPrice());
        }

        System.out.println();
        System.out.println("==== RECEIPT ====");

        double total = 0;

        for (int i = 0; i < items.length; i++) {

            double lineTotal = items[i].calculateTotal(quantities[i]);

            System.out.printf("%s x%d = UGX %.2f%n", items[i].getName(), quantities[i], lineTotal);

            total += lineTotal;
        }

        System.out.println("---------------------------------------");
        System.out.printf("TOTAL = UGX %.2f%n", total);
    }
}
