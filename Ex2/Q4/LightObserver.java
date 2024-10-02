public class LightObserver implements Observer {
    private Light light;
    private SmartHub hub;

    public LightObserver(Light light, SmartHub hub) {
        this.light = light;
        this.hub = hub;
        hub.addObserver(this);
    }

    @Override
    public void update(String condition) {
        if (condition.equals("temperature > 75")) {
            light.turnOff();
        }
    }
}
