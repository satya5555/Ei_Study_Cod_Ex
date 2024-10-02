import java.util.logging.*;

public class Thermostat implements SmartDevice {
    private int id;
    private int temperature;
    private static final Logger logger = Logger.getLogger(Thermostat.class.getName());

    public Thermostat(int id, int initialTemp) {
        this.id = id;
        this.temperature = initialTemp;
    }

    @Override
    public void turnOn() {
        logger.info("Thermostat " + id + " is active. Current temperature is " + temperature + "°.");
    }

    @Override
    public void turnOff() {
        logger.info("Thermostat " + id + " is deactivated.");
    }

    @Override
    public String getStatus() {
        return "Thermostat " + id + " is set to " + temperature + "°";
    }

    public void setTemperature(int temp) {
        this.temperature = temp;
        logger.info("Thermostat " + id + " temperature set to " + temperature + "°.");
    }

    @Override
    public int getId() {
        return id;
    }
}
