package src.controller;

public class AutomationController {
    private static AutomationController instance;

    private AutomationController() {}

    public static AutomationController getInstance() {
        if (instance == null) {
            instance = new AutomationController();
        }
        return instance;
    }

    public void initiateSystem() {
        System.out.println("Home automation system initiated.");
    }
}