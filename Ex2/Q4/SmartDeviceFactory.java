  public class SmartDeviceFactory {
    public static SmartDevice createDevice(String type, int id) {
        switch (type.toLowerCase()) {
            case "light":
                return new Light(id);
            case "thermostat":
                return new Thermostat(id, 70); // Default temperature
            case "door":
                return new DoorLock(id);
            default:
                throw new IllegalArgumentException("Invalid device type.");
        }
    }
}
