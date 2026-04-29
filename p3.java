import java.util.Scanner;

class p3 {
    private double num1;
    private double num2;

    void setNumbers(double num1, double num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    double sum() {
        return num1 + num2;
    }

    double product() {
        return num1 * num2;
    }

    double difference() {
        return num1 - num2;
    }

    double divide() {
        if (num2 == 0) throw new ArithmeticException("Division by zero");
        return num1 / num2;
    }

    void displayResults() {
        System.out.println("\nNumber 1 : " + num1);
        System.out.println("Number 2 : " + num2);
        System.out.println("Sum      : " + sum());
        System.out.println("Product  : " + product());
        System.out.println("Difference: " + difference());
        try {
            System.out.println("Division : " + divide());
        } catch (ArithmeticException e) {
            System.out.println("Division : " + e.getMessage());
        }
    }
}

public class p3 {
    public static void main(String[] args) {
        double num1, num2;

        // Supports both command-line args and user input
        if (args.length >= 2) {
            num1 = Double.parseDouble(args[0]);
            num2 = Double.parseDouble(args[1]);
            System.out.println("Using command-line arguments.");
        } else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter first number: ");
            num1 = sc.nextDouble();
            System.out.print("Enter second number: ");
            num2 = sc.nextDouble();
            sc.close();
        }

        Calculator calc = new Calculator();
        calc.setNumbers(num1, num2);
        calc.displayResults();
    }
}
