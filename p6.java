import java.util.Scanner;

class BillGenerator {

    void generateBill(int itemTotal) {
        System.out.println("\n[Regular Customer]");
        System.out.println("Item Total : Rs." + itemTotal);
        System.out.println("Discount   : None");
        System.out.println("Final Bill : Rs." + itemTotal);
    }

    void generateBill(int itemTotal, int discount) {
        int finalAmount = itemTotal - discount;
        System.out.println("\n[Privileged Customer]");
        System.out.println("Item Total : Rs." + itemTotal);
        System.out.println("Discount   : Rs." + discount);
        System.out.println("Final Bill : Rs." + finalAmount);
    }

    void generateBill(int itemTotal, double discountPercent) {
        double discountAmt = itemTotal * discountPercent / 100;
        double finalAmount = itemTotal - discountAmt;
        System.out.println("\n[Festive Offer]");
        System.out.println("Item Total : Rs." + itemTotal);
        System.out.printf("Discount   : %.1f%% = Rs.%.2f%n", discountPercent, discountAmt);
        System.out.printf("Final Bill : Rs.%.2f%n", finalAmount);
    }
}

public class p6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BillGenerator bg = new BillGenerator();

        System.out.println("--- Shopping Mall Billing System ---");
        System.out.println("1. Regular Customer (No Discount)");
        System.out.println("2. Privileged Customer (Flat Discount)");
        System.out.println("3. Festive Offer (Percentage Discount)");
        System.out.print("Select customer type: ");
        int choice = sc.nextInt();

        System.out.print("Enter item total (Rs.): ");
        int total = sc.nextInt();

        switch (choice) {
            case 1:
                bg.generateBill(total);
                break;

            case 2:
                System.out.print("Enter flat discount amount (Rs.): ");
                int discount = sc.nextInt();
                bg.generateBill(total, discount);
                break;

            case 3:
                System.out.print("Enter discount percentage: ");
                double percent = sc.nextDouble();
                bg.generateBill(total, percent);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
