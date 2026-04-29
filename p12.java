import java.util.Scanner;

interface Order {
    void placeOrder(String item, int qty);
    void cancelOrder(int orderId);
    void generateBill();
}

abstract class PartialOrder implements Order {
    protected String item;
    protected int qty;
    protected int orderId;
    protected double pricePerUnit = 150.0;

    @Override
    public void placeOrder(String item, int qty) {
        this.item = item;
        this.qty = qty;
        this.orderId = (int)(Math.random() * 9000) + 1000;
        System.out.println("Order placed successfully!");
        System.out.println("  Item     : " + item);
        System.out.println("  Quantity : " + qty);
        System.out.println("  Order ID : " + orderId);
    }
}

class FinalOrder extends PartialOrder {

    @Override
    public void cancelOrder(int orderId) {
        if (this.orderId == orderId) {
            System.out.println("Order ID " + orderId + " cancelled successfully.");
            this.item = null;
            this.qty = 0;
        } else {
            System.out.println("Order ID " + orderId + " not found.");
        }
    }

    @Override
    public void generateBill() {
        if (item == null) {
            System.out.println("No active order to generate bill.");
            return;
        }
        double total = qty * pricePerUnit;
        System.out.println("========== BILL ==========");
        System.out.println("Order ID : " + orderId);
        System.out.println("Item     : " + item);
        System.out.println("Qty      : " + qty);
        System.out.printf("Price    : Rs.%.2f each%n", pricePerUnit);
        System.out.printf("TOTAL    : Rs.%.2f%n", total);
        System.out.println("==========================");
    }
}

public class p12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        FinalOrder order = new FinalOrder();

        System.out.println("--- Online Order Processing System ---");
        System.out.print("Enter item name: ");
        String item = sc.next();
        System.out.print("Enter quantity: ");
        int qty = sc.nextInt();

        order.placeOrder(item, qty);

        System.out.println("\n1. Generate Bill");
        System.out.println("2. Cancel Order");
        System.out.print("Choose action: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                order.generateBill();
                break;
            case 2:
                System.out.print("Enter Order ID to cancel: ");
                int oid = sc.nextInt();
                order.cancelOrder(oid);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
