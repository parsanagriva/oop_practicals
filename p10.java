import java.util.Scanner;

class Vehicle {
    protected String vehicleNumber;
    protected String brand;
    protected String fuelType;

    Vehicle(String vehicleNumber, String brand, String fuelType) {
        this.vehicleNumber = vehicleNumber;
        this.brand = brand;
        this.fuelType = fuelType;
    }

    void displayDetails() {
        System.out.println("Vehicle No : " + vehicleNumber);
        System.out.println("Brand      : " + brand);
        System.out.println("Fuel Type  : " + fuelType);
    }
}

class Car extends Vehicle {
    private int numberOfSeats;
    private boolean ACavailable;

    Car(String vehicleNumber, String brand, String fuelType, int numberOfSeats, boolean ACavailable) {
        super(vehicleNumber, brand, fuelType);
        this.numberOfSeats = numberOfSeats;
        this.ACavailable = ACavailable;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Seats      : " + numberOfSeats);
        System.out.println("AC         : " + (ACavailable ? "Yes" : "No"));
    }
}

class ElectricCar extends Car {
    private double batteryCapacity;
    private int chargingTime;

    ElectricCar(String vehicleNumber, String brand, int numberOfSeats, boolean ACavailable, double batteryCapacity, int chargingTime) {
        super(vehicleNumber, brand, "Electric", numberOfSeats, ACavailable);
        this.batteryCapacity = batteryCapacity;
        this.chargingTime = chargingTime;
    }

    @Override
    void displayDetails() {
        super.displayDetails();
        System.out.println("Battery    : " + batteryCapacity + " kWh");
        System.out.println("Charge Time: " + chargingTime + " hrs");
    }
}

public class p10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=== Enter Vehicle Details ===");
        System.out.print("Vehicle Number: ");
        String vn = sc.next();
        System.out.print("Brand: ");
        String vb = sc.next();
        System.out.print("Fuel Type: ");
        String vf = sc.next();
        Vehicle v = new Vehicle(vn, vb, vf);

        System.out.println("\n=== Enter Car Details ===");
        System.out.print("Vehicle Number: ");
        String cn = sc.next();
        System.out.print("Brand: ");
        String cb = sc.next();
        System.out.print("Fuel Type: ");
        String cf = sc.next();
        System.out.print("Number of Seats: ");
        int seats = sc.nextInt();
        System.out.print("AC Available (true/false): ");
        boolean ac = sc.nextBoolean();
        Car car = new Car(cn, cb, cf, seats, ac);

        System.out.println("\n=== Enter Electric Car Details ===");
        System.out.print("Vehicle Number: ");
        String en = sc.next();
        System.out.print("Brand: ");
        String eb = sc.next();
        System.out.print("Number of Seats: ");
        int eSeats = sc.nextInt();
        System.out.print("AC Available (true/false): ");
        boolean eAc = sc.nextBoolean();
        System.out.print("Battery Capacity (kWh): ");
        double bat = sc.nextDouble();
        System.out.print("Charging Time (hours): ");
        int charge = sc.nextInt();
        ElectricCar ec = new ElectricCar(en, eb, eSeats, eAc, bat, charge);

        System.out.println("\n--- Vehicle ---");
        v.displayDetails();

        System.out.println("\n--- Car ---");
        car.displayDetails();

        System.out.println("\n--- Electric Car ---");
        ec.displayDetails();

        // Upcasting demo
        System.out.println("\n--- Upcasting: Vehicle v2 = new Car(...) ---");
        Vehicle v2 = car;
        v2.displayDetails();

        // Downcasting with instanceof
        System.out.println("\n--- instanceof checks ---");
        System.out.println("ec instanceof ElectricCar: " + (ec instanceof ElectricCar));
        System.out.println("ec instanceof Car        : " + (ec instanceof Car));
        System.out.println("ec instanceof Vehicle    : " + (ec instanceof Vehicle));

        if (v2 instanceof Car) {
            Car downcast = (Car) v2;
            System.out.println("\nDowncasting successful. Car details:");
            downcast.displayDetails();
        }

        sc.close();
    }
}
