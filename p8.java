import java.util.Scanner;

class University {
    static String universityName;
    static int totalStudents;

    static {
        universityName = "SSASIT";
        totalStudents = 0;
        System.out.println("[Static Block] Executed once. University: " + universityName);
    }

    String studentName;
    int rollNumber;

    {
        totalStudents++;
        System.out.println("[Instance Block] Executed. Total students so far: " + totalStudents);
    }

    University(String name, int roll) {
        this.studentName = name;
        this.rollNumber = roll;
        System.out.println("[Constructor] Student created -> Name: " + name + ", Roll: " + roll);
    }

    static int getTotalStudents() {
        return totalStudents;
    }

    void display() {
        System.out.println("  Name: " + studentName + " | Roll: " + rollNumber + " | University: " + universityName);
    }
}

public class p8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many students to create? ");
        int n = sc.nextInt();

        University[] students = new University[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\n--- Student " + (i + 1) + " ---");
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Roll Number: ");
            int roll = sc.nextInt();
            students[i] = new University(name, roll);
        }

        System.out.println("\n--- All Students ---");
        for (University u : students) {
            u.display();
        }

        System.out.println("\nTotal Students via static method: " + University.getTotalStudents());

        sc.close();
    }
}
