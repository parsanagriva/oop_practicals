import java.util.Scanner;

class p9 {
    private String password;

    void setPassword(String password) {
        this.password = password;
    }

    boolean isValidPassword() {
        if (password.length() < 8) return false;

        int digitCount = 0;
        for (char c : password.toCharArray()) {
            if (!Character.isLetterOrDigit(c)) return false;
            if (Character.isDigit(c)) digitCount++;
        }
        return digitCount >= 2;
    }

    void displayResult() {
        System.out.println("\nPassword: " + password);
        if (isValidPassword()) {
            System.out.println("Result: Valid Password");
        } else {
            System.out.println("Result: Invalid Password");
            System.out.println("Rules:");
            System.out.println("  - At least 8 characters");
            System.out.println("  - Only letters and digits allowed");
            System.out.println("  - At least 2 digits required");
        }
    }
}

public class p9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Password Validator ---");
        System.out.print("Enter password: ");
        String input = sc.next();

        PasswordValidator pv = new PasswordValidator();
        pv.setPassword(input);
        pv.displayResult();

        sc.close();
    }
}
