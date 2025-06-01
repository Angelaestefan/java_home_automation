package src.factory;

import src.model.LightSource;

public class LightDevice extends LightSource implements Device {
    public LightDevice(String hue, int level, String status) {
        super(new Configurator(hue).setLevel(level).setStatus(status));
    }
}