import java.util.Scanner;

class BankAccount {
    String accountId;
    String accountHolderName;
    double balance;

    void assignValues(String id, String name, double bal) {
        this.accountId = id;
        this.accountHolderName = name;
        this.balance = bal;
    }

    void displayValues() {
        System.out.println("  ID: " + accountId + " | Name: " + accountHolderName + " | Balance: Rs." + balance);
    }
}

class BankAccountManager {
    BankAccount[] accounts;
    int count;

    BankAccountManager(int size) {
        accounts = new BankAccount[size];
        count = 0;
    }

    void addAccount(String id, String name, double balance) {
        if (count < accounts.length) {
            accounts[count] = new BankAccount();
            accounts[count].assignValues(id, name, balance);
            count++;
            System.out.println("Account added successfully.");
        } else {
            System.out.println("Account array is full.");
        }
    }

    void displayAll() {
        System.out.println("\nAll Accounts:");
        for (int i = 0; i < count; i++) {
            accounts[i].displayValues();
        }
    }

    void search(String id) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].accountId.equals(id)) {
                System.out.println("Account Found:");
                accounts[i].displayValues();
                return;
            }
        }
        System.out.println("Account with ID '" + id + "' not found.");
    }
}

public class p5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BankAccountManager manager = new BankAccountManager(10);

        int choice;
        do {
            System.out.println("\n--- Bank Account Menu ---");
            System.out.println("1. Add Account");
            System.out.println("2. Display All Accounts");
            System.out.println("3. Search Account by ID");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Account ID: ");
                    String id = sc.next();
                    System.out.print("Account Holder Name: ");
                    String name = sc.next();
                    System.out.print("Initial Balance: ");
                    double bal = sc.nextDouble();
                    manager.addAccount(id, name, bal);
                    break;

                case 2:
                    manager.displayAll();
                    break;

                case 3:
                    System.out.print("Enter Account ID to search: ");
                    String searchId = sc.next();
                    manager.search(searchId);
                    break;

                case 4:
                    System.out.println("Exiting.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 4);

        sc.close();
    }
}
