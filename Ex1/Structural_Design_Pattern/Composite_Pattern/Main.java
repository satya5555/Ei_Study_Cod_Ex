import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Component Interface
interface Graphic {
    void draw();
}

// Leaf Class
class Circle implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Circle");
    }
}

// Leaf Class
class Square implements Graphic {
    @Override
    public void draw() {
        System.out.println("Drawing a Square");
    }
}

// Composite Class
class CompositeGraphic implements Graphic {
    private List<Graphic> graphics = new ArrayList<>();

    public void add(Graphic graphic) {
        graphics.add(graphic);
    }

    public void remove(Graphic graphic) {
        graphics.remove(graphic);
    }

    @Override
    public void draw() {
        for (Graphic graphic : graphics) {
            graphic.draw();
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompositeGraphic composite = new CompositeGraphic();

        System.out.print("Enter the number of shapes to draw (1.Circle 2.Square): ");
        int numShapes = scanner.nextInt();

        for (int i = 0; i < numShapes; i++) {
            System.out.print("Enter shape type (1 for Circle, 2 for Square): ");
            int shapeType = scanner.nextInt();
            if (shapeType == 1) {
                composite.add(new Circle());
            } else if (shapeType == 2) {
                composite.add(new Square());
            } else {
                System.out.println("Invalid shape type.");
            }
        }

        composite.draw();
        scanner.close();
    }
}
