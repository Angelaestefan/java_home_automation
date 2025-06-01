package src.Main;

import src.command.ActivateLightCommand;
import src.command.Command;
import src.controller.AutomationController;
import src.facade.HomeSystem;
import src.model.LightSource;

public class HomeAutomationApp {
    public static void main(String[] args) {
        HomeSystem home = new HomeSystem();

        LightSource light = new LightSource.Configurator("White")
            .setLevel(75)
            .setStatus("ON")
            .build();

        Command activateLight = new ActivateLightCommand(light);

        home.activateDevice(activateLight);
    }
}