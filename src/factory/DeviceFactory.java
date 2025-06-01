package src.factory;


public class DeviceFactory {
    public static Device createDevice(String type, String hue, int level, String status) {
        if (type.equalsIgnoreCase("light")) {
            return new LightDevice(hue, level, status);
        }
        throw new IllegalArgumentException("Unsupported device type: " + type);
    }
}