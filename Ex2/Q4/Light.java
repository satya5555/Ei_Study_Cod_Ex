import java.util.logging.*;

public class Light implements SmartDevice {
    private int id;
    private String status;
    private static final Logger logger = Logger.getLogger(Light.class.getName());

    public Light(int id) {
        this.id = id;
        this.status = "off";
    }

    @Override
    public void turnOn() {
        status = "on";
        logger.info("Light " + id + " is now ON.");
    }

    @Override
    public void turnOff() {
        status = "off";
        logger.info("Light " + id + " is now OFF.");
    }

    @Override
    public String getStatus() {
        return "Light " + id + " is " + status;
    }

    @Override
    public int getId() {
        return id;
    }
}
