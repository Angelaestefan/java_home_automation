package src.command;

import src.model.LightSource;

public class ActivateLightCommand implements Command {
    private LightSource light;

    public ActivateLightCommand(LightSource light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Activating light: " + light);
    }
}