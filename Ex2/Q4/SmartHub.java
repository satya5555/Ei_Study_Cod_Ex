import java.util.*;
import java.util.logging.*;
import java.util.regex.*;

public class SmartHub {
    private List<Observer> observers = new ArrayList<>();
    private List<SmartDevice> devices = new ArrayList<>();
    private List<String> scheduledTasks = new ArrayList<>();
    private String currentCondition;
    private static final Logger logger = Logger.getLogger(SmartHub.class.getName());

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    public void setCondition(String condition) {
        this.currentCondition = condition;
        notifyAllObservers();
    }

    public void notifyAllObservers() {
        for (Observer observer : observers) {
            observer.update(currentCondition);
        }
    }

    public void registerDevice(SmartDevice device) {
        devices.add(device);
    }

    public String getStatusReport() {
        StringBuilder report = new StringBuilder();
        for (SmartDevice device : devices) {
            report.append(device.getStatus()).append("\n");
        }
        return report.toString();
    }

    public void displayScheduledTasks() {
        System.out.println("Scheduled Tasks: " + scheduledTasks);
    }

    public void executeCommand(String command) {
        try {
            if (command.startsWith("turnOn")) {
                int id = extractId(command);
                turnOnDevice(id);
            } else if (command.startsWith("turnOff")) {
                int id = extractId(command);
                turnOffDevice(id);
            } else if (command.startsWith("setSchedule")) {
                String[] details = extractSchedule(command);
                scheduleTask(details[0], details[1], details[2]);
            } else if (command.startsWith("addTrigger")) {
                String[] trigger = extractTrigger(command);
                addAutomationTrigger(trigger[0], trigger[1], trigger[2], trigger[3]);
            } else {
                throw new IllegalArgumentException("Unknown command: " + command);
            }
        } catch (Exception e) {
            logger.warning("Failed to execute command: " + command + " due to " + e.getMessage());
            throw e; // Rethrow to be caught in main loop
        }
    }

    private int extractId(String command) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(command);
        if (matcher.find()) {
            return Integer.parseInt(matcher.group());
        }
        throw new IllegalArgumentException("Invalid command format.");
    }

    private String[] extractSchedule(String command) {
        return command.substring(command.indexOf("(") + 1, command.indexOf(")")).split(",");
    }

    private String[] extractTrigger(String command) {
        String rawParams = command.substring(command.indexOf("(") + 1, command.indexOf(")"));
        String[] parts = rawParams.split(",\\s*");
        for (int i = 0; i < parts.length; i++) {
            parts[i] = parts[i].replaceAll("'", "").trim();
        }
        return parts;
    }

    private void turnOnDevice(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                device.turnOn();
                return; // Exit after finding and operating on the device
            }
        }
        throw new IllegalArgumentException("Device with ID " + id + " not found.");
    }

    private void turnOffDevice(int id) {
        for (SmartDevice device : devices) {
            if (device.getId() == id) {
                device.turnOff();
                return; // Exit after finding and operating on the device
            }
        }
        throw new IllegalArgumentException("Device with ID " + id + " not found.");
    }

    private void scheduleTask(String deviceId, String time, String action) {
        scheduledTasks.add("Device " + deviceId + " at " + time + ": " + action);
        logger.info("Scheduled task: Device " + deviceId + " at " + time + ": " + action);
    }

    private void addAutomationTrigger(String parameter, String condition, String value, String action) {
        System.out.println("Automation Trigger Added: If " + parameter + " " + condition + " " + value + ", then " + action + ")");
        logger.info("Automation Trigger Added: If " + parameter + " " + condition + " " + value + ", then " + action + ")");
    }
}
