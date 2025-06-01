package src.facade;

import src.command.Command;
import src.controller.AutomationController;

public class HomeSystem {
    private final AutomationController controller;

    public HomeSystem() {
        this.controller = AutomationController.getInstance();
    }

    public void activateDevice(Command command) {
        controller.initiateSystem();
        command.execute();
    }
}