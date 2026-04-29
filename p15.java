import java.util.Scanner;

class NotSufficientFundException extends Exception {
    NotSufficientFundException(String message) {
        super(message);
    }
}

class BankAccount {
    private double balance;

    BankAccount() {
        this.balance = 1000.00;
        System.out.println("Account created. Initial Balance: Rs." + balance);
    }

    void deposit(double amount) {
        balance += amount;
        System.out.printf("Deposited: Rs.%.2f | Balance: Rs.%.2f%n", amount, balance);
    }

    void withdraw(double amount) throws NotSufficientFundException {
        if (amount > balance) {
            throw new NotSufficientFundException("Not Sufficient Fund. Available: Rs." + balance);
        }
        balance -= amount;
        System.out.printf("Withdrawn: Rs.%.2f | Balance: Rs.%.2f%n", amount, balance);
    }

    double getBalance() {
        return balance;
    }
}

public class p15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.print("\nEnter deposit amount: ");
        double deposit = sc.nextDouble();
        account.deposit(deposit);

        System.out.print("How many withdrawals to perform? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.print("Withdrawal " + (i + 1) + " amount: ");
            double amount = sc.nextDouble();
            try {
                account.withdraw(amount);
            } catch (NotSufficientFundException e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

        System.out.printf("\nFinal Balance: Rs.%.2f%n", account.getBalance());
        sc.close();
    }
}
