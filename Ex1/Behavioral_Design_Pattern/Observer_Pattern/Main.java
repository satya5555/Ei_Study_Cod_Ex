import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String message);
}

// Concrete Observer
class User implements Observer {
    private String name;

    public User(String name) {
        this.name = name;
    }

    @Override
    public void update(String message) {
        System.out.println(name + " received message: " + message);
    }
}

// Subject Class
class MessageSender {
    private List<Observer> observers = new ArrayList<>();

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers(String message) {
        for (Observer observer : observers) {
            observer.update(message);
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();
        User user1 = new User("Alice");
        User user2 = new User("Bob");

        sender.addObserver(user1);
        sender.addObserver(user2);

        sender.notifyObservers("Hello, this is a message!");
    }
}
