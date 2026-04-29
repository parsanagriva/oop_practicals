import java.util.Scanner;

class SumThread extends Thread {
    private int start;
    private int end;
    private long result;

    SumThread(String name, int start, int end) {
        super(name);
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        result = 0;
        for (int i = start; i <= end; i++) {
            result += i;
        }
        System.out.println(getName() + ": Sum from " + start + " to " + end + " = " + result);
    }

    long getResult() {
        return result;
    }
}

public class p16 {
    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("--- Parallel Sum using Two Threads ---");
        System.out.print("Enter start of range: ");
        int start = sc.nextInt();
        System.out.print("Enter end of range: ");
        int end = sc.nextInt();

        int mid = (start + end) / 2;

        SumThread t1 = new SumThread("Thread-1", start, mid);
        SumThread t2 = new SumThread("Thread-2", mid + 1, end);

        System.out.println("\nStarting threads...");
        t1.start();
        t2.start();

        t1.join();
        t2.join();

        long total = t1.getResult() + t2.getResult();
        System.out.println("\nCombined Sum (" + start + " to " + end + ") = " + total);

        sc.close();
    }
}
