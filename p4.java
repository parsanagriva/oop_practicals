import java.util.Scanner;

class Time {
    int hours;
    int minutes;

    void setTime(int h, int m) {
        this.hours = h;
        this.minutes = m;
    }

    void displayTime() {
        System.out.printf("Time: %02d:%02d%n", hours, minutes);
    }

    void addTime(Time t1, Time t2) {
        int totalMinutes = t1.minutes + t2.minutes;
        this.minutes = totalMinutes % 60;
        this.hours = t1.hours + t2.hours + (totalMinutes / 60);
    }
}

public class p4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Time 1:");
        System.out.print("  Hours: ");
        int h1 = sc.nextInt();
        System.out.print("  Minutes: ");
        int m1 = sc.nextInt();

        System.out.println("Enter Time 2:");
        System.out.print("  Hours: ");
        int h2 = sc.nextInt();
        System.out.print("  Minutes: ");
        int m2 = sc.nextInt();

        Time t1 = new Time();
        Time t2 = new Time();
        Time result = new Time();

        t1.setTime(h1, m1);
        t2.setTime(h2, m2);

        System.out.print("\nTime 1 -> "); t1.displayTime();
        System.out.print("Time 2 -> "); t2.displayTime();

        result.addTime(t1, t2);
        System.out.print("Sum    -> "); result.displayTime();

        sc.close();
    }
}
