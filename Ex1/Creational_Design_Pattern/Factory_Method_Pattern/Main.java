import java.util.Scanner;

// Product Interface
interface Animal {
    void speak();
}

// Concrete Product 1
class Dog implements Animal {
    @Override
    public void speak() {
        System.out.println("Woof!");
    }
}

// Concrete Product 2
class Cat implements Animal {
    @Override
    public void speak() {
        System.out.println("Meow!");
    }
}

// Creator Class
abstract class AnimalFactory {
    public abstract Animal createAnimal();
}

// Concrete Creator 1
class DogFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}

// Concrete Creator 2
class CatFactory extends AnimalFactory {
    @Override
    public Animal createAnimal() {
        return new Cat();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an animal: 1.Dog 2.Cat");
        int choice = scanner.nextInt();

        Animal animal;
        switch (choice) {
            case 1:
                animal = new DogFactory().createAnimal();
                break;
            case 2:
                animal = new CatFactory().createAnimal();
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }
        animal.speak();
        scanner.close();
    }
}
