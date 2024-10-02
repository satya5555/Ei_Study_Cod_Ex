import java.util.Scanner;

// Target Interface
interface Car {
    void drive();
}

// Adaptee Class
class OldCar {
    public void startEngine() {
        System.out.println("Old car engine started.");
    }
}

// Adapter Class
class CarAdapter implements Car {
    private OldCar oldCar;

    public CarAdapter(OldCar oldCar) {
        this.oldCar = oldCar;
    }

    @Override
    public void drive() {
        oldCar.startEngine();
        System.out.println("Driving the old car.");
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Would you like to drive an old car? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            OldCar oldCar = new OldCar();
            Car car = new CarAdapter(oldCar);
            car.drive();
        } else {
            System.out.println("Maybe next time!");
        }

        scanner.close();
    }
}
