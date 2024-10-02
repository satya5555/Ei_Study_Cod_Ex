import java.util.Scanner;

// Singleton Class
class Logger {
    private static Logger instance;

    private Logger() {}

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("Log: " + message);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.print("Enter a message to log: ");
        String message = scanner.nextLine();
        logger.log(message);
        scanner.close();
    }
}
