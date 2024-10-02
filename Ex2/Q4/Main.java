import java.util.*;
import java.util.logging.*;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        SmartHub hub = new SmartHub();
        SmartDevice light1 = SmartDeviceFactory.createDevice("light", 1);
        SmartDevice thermostat = SmartDeviceFactory.createDevice("thermostat", 2);
        SmartDevice door = SmartDeviceFactory.createDevice("door", 3);

        hub.registerDevice(light1);
        hub.registerDevice(thermostat);
        hub.registerDevice(door);

        new LightObserver((Light) light1, hub);

        boolean running = true;
        while (running) {
            System.out.println("Enter a command (type 'exit' to quit):");
            String command = scanner.nextLine().trim();
            if (command.equalsIgnoreCase("exit")) {
                running = false;
                logger.info("Exiting the application.");
            } else {
                try {
                    hub.executeCommand(command);
                    System.out.println(hub.getStatusReport());
                } catch (IllegalArgumentException | InputMismatchException e) {
                    logger.warning("Error: " + e.getMessage());
                    System.out.println("Invalid command. Please try again.");
                } catch (Exception e) {
                    logger.severe("Unexpected error: " + e.getMessage());
                    System.out.println("An unexpected error occurred. Please try again.");
                }
            }
        }

        hub.displayScheduledTasks();
    }
}
