import java.util.Scanner;

class p2 {
    private String number;

    void setNumber(String number) {
        this.number = number;
    }

    String incrementDigits() {
        char[] digits = number.toCharArray();
        int[] output = new int[digits.length];
        int carry = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int d = (digits[i] - '0') + 1 + carry;
            output[i] = d % 10;
            carry = d / 10;
        }

        StringBuilder result = new StringBuilder();
        for (int d : output) result.append(d);
        return result.toString();
    }

    boolean isValid() {
        return number.length() == 5 && number.matches("\\d+");
    }
}

public class p2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a 5-digit number: ");
        String input = sc.next();

        DigitProcessor dp = new DigitProcessor();
        dp.setNumber(input);

        if (!dp.isValid()) {
            System.out.println("Invalid input. Please enter exactly 5 digits.");
            sc.close();
            return;
        }

        String result = dp.incrementDigits();
        System.out.println("Input:  " + input);
        System.out.println("Output: " + result);

        sc.close();
    }
}
