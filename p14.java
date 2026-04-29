import java.util.Scanner;

class AverageCalculator {
    double average(String[] values) throws NullPointerException, NumberFormatException {
        double sum = 0;
        for (String val : values) {
            if (val == null) {
                throw new NullPointerException("Null element found in array.");
            }
            sum += Double.parseDouble(val);
        }
        return sum / values.length;
    }
}

public class p14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AverageCalculator calc = new AverageCalculator();

        System.out.print("How many values to enter? ");
        int n = sc.nextInt();
        String[] values = new String[n];

        System.out.println("Enter " + n + " values (type 'null' to simulate null):");
        for (int i = 0; i < n; i++) {
            System.out.print("Value " + (i + 1) + ": ");
            String input = sc.next();
            values[i] = input.equalsIgnoreCase("null") ? null : input;
        }

        try {
            double avg = calc.average(values);
            System.out.printf("Average: %.2f%n", avg);
        } catch (NullPointerException e) {
            System.out.println("NullPointerException caught: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException caught: Invalid number in input.");
        } finally {
            System.out.println("Finally block: Execution complete.");
        }

        sc.close();
    }
}
