import java.util.logging.*;

public class DoorLock implements SmartDevice {
    private int id;
    private String status;
    private static final Logger logger = Logger.getLogger(DoorLock.class.getName());

    public DoorLock(int id) {
        this.id = id;
        this.status = "locked";
    }

    @Override
    public void turnOn() {
        status = "locked";
        logger.info("Door " + id + " is now LOCKED.");
    }

    @Override
    public void turnOff() {
        status = "unlocked";
        logger.info("Door " + id + " is now UNLOCKED.");
    }

    @Override
    public String getStatus() {
        return "Door " + id + " is " + status;
    }

    @Override
    public int getId() {
        return id;
    }
}
