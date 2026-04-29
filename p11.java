import java.util.Scanner;

class Payment {
    void processPayment(int amount) {
        System.out.println("Processing payment of Rs." + amount);
    }
}

class CreditCardPayment extends Payment {
    @Override
    void processPayment(int amount) {
        System.out.println("Payment of Rs." + amount + " done using Credit Card");
    }
}

class UPIPayment extends Payment {
    @Override
    void processPayment(int amount) {
        System.out.println("Payment of Rs." + amount + " done using UPI");
    }
}

public class p11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Online Payment System ---");
        System.out.println("1. Credit Card");
        System.out.println("2. UPI");
        System.out.print("Select payment method: ");
        int choice = sc.nextInt();

        System.out.print("Enter amount (Rs.): ");
        int amount = sc.nextInt();

        Payment payment;

        switch (choice) {
            case 1:
                payment = new CreditCardPayment();
                break;
            case 2:
                payment = new UPIPayment();
                break;
            default:
                System.out.println("Invalid choice.");
                sc.close();
                return;
        }

        payment.processPayment(amount);
        sc.close();
    }
}
