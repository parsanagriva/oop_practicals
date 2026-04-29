import java.util.ArrayList;
import java.util.Scanner;

class Box<T> {
    private ArrayList<T> items = new ArrayList<>();
    private String boxName;

    Box(String boxName) {
        this.boxName = boxName;
    }

    void addItem(T item) {
        items.add(item);
    }

    void displayItems() {
        System.out.println(boxName + " -> " + items);
    }

    int size() {
        return items.size();
    }
}

public class p19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many names to add? ");
        int n1 = sc.nextInt();
        Box<String> nameBox = new Box<>("Name Box");
        System.out.println("Enter " + n1 + " names:");
        for (int i = 0; i < n1; i++) {
            System.out.print("  Name " + (i + 1) + ": ");
            nameBox.addItem(sc.next());
        }

        System.out.print("\nHow many roll numbers to add? ");
        int n2 = sc.nextInt();
        Box<Integer> rollBox = new Box<>("Roll Box");
        System.out.println("Enter " + n2 + " roll numbers:");
        for (int i = 0; i < n2; i++) {
            System.out.print("  Roll " + (i + 1) + ": ");
            rollBox.addItem(sc.nextInt());
        }

        System.out.println("\n--- Stored Items ---");
        nameBox.displayItems();
        rollBox.displayItems();

        sc.close();
    }
}
