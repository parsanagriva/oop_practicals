import java.util.Scanner;

class LoanCalculator {

    // Home Loan
    void calculateEMI(int principal, int time, float rate) {
        double r = rate / (12 * 100);
        int n = time * 12;
        double emi = (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        System.out.println("\n[Home Loan EMI Calculation]");
        System.out.println("Principal : Rs." + principal);
        System.out.println("Time      : " + time + " years");
        System.out.printf("Rate      : %.2f%%%n", rate);
        System.out.printf("Monthly EMI: Rs.%.2f%n", emi);
    }

    // Vehicle Loan
    void calculateEMI(double principal, int time, double rate) {
        double r = rate / (12 * 100);
        int n = time * 12;
        double emi = (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        System.out.println("\n[Vehicle Loan EMI Calculation]");
        System.out.printf("Principal : Rs.%.2f%n", principal);
        System.out.println("Time      : " + time + " years");
        System.out.printf("Rate      : %.2f%%%n", rate);
        System.out.printf("Monthly EMI: Rs.%.2f%n", emi);
    }

    // Personal Short-Term Loan (fixed 10%)
    void calculateEMI(int principal, int time) {
        double rate = 10.0;
        double r = rate / (12 * 100);
        int n = time * 12;
        double emi = (principal * r * Math.pow(1 + r, n)) / (Math.pow(1 + r, n) - 1);
        System.out.println("\n[Personal Loan EMI Calculation]");
        System.out.println("Principal : Rs." + principal);
        System.out.println("Time      : " + time + " years");
        System.out.println("Rate      : 10% (fixed)");
        System.out.printf("Monthly EMI: Rs.%.2f%n", emi);
    }
}

public class p7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LoanCalculator lc = new LoanCalculator();

        System.out.println("--- Loan EMI Calculator ---");
        System.out.println("1. Home Loan");
        System.out.println("2. Vehicle Loan");
        System.out.println("3. Personal Loan (10% fixed rate)");
        System.out.print("Select loan type: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter principal (int, Rs.): ");
                int hp = sc.nextInt();
                System.out.print("Enter time (years): ");
                int ht = sc.nextInt();
                System.out.print("Enter annual interest rate (%): ");
                float hr = sc.nextFloat();
                lc.calculateEMI(hp, ht, hr);
                break;

            case 2:
                System.out.print("Enter principal (double, Rs.): ");
                double vp = sc.nextDouble();
                System.out.print("Enter time (years): ");
                int vt = sc.nextInt();
                System.out.print("Enter annual interest rate (%): ");
                double vr = sc.nextDouble();
                lc.calculateEMI(vp, vt, vr);
                break;

            case 3:
                System.out.print("Enter principal (int, Rs.): ");
                int pp = sc.nextInt();
                System.out.print("Enter time (years): ");
                int pt = sc.nextInt();
                lc.calculateEMI(pp, pt);
                break;

            default:
                System.out.println("Invalid choice.");
        }

        sc.close();
    }
}
