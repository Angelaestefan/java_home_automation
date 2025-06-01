// Singleton
class AutomationController {
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

// Builder
class LightSource {
    private final String hue;
    private final int level;
    private final String status;

    protected LightSource(Configurator config) {
        this.hue = config.hue;
        this.level = config.level;
        this.status = config.status;
    }

    public static class Configurator {
        private String hue;
        private int level;
        private String status;

        public Configurator(String hue) {
            this.hue = hue;
        }

        public Configurator setLevel(int level) {
            this.level = level;
            return this;
        }

        public Configurator setStatus(String status) {
            this.status = status;
            return this;
        }

        public LightSource build() {
            return new LightSource(this);
        }
    }

    @Override
    public String toString() {
        return "LightSource{" +
               "hue='" + hue + '\'' +
               ", level=" + level +
               ", status='" + status + '\'' +
               '}';
    }
}

// Factory Pattern
interface Device {}
class LightDevice extends LightSource implements Device {
    public LightDevice(String hue, int level, String status) {
        super(new Configurator(hue).setLevel(level).setStatus(status));
    }
}

class DeviceFactory {
    public static Device createDevice(String type, String hue, int level, String status) {
        if (type.equalsIgnoreCase("light")) {
            return new LightDevice(hue, level, status);
        }
        throw new IllegalArgumentException("Unsupported device type: " + type);
    }
}

// Command Pattern
interface Command {
    void execute();
}

class ActivateLightCommand implements Command {
    private LightSource light;

    public ActivateLightCommand(LightSource light) {
        this.light = light;
    }

    @Override
    public void execute() {
        System.out.println("Activating light: " + light);
    }
}

// Facade Pattern
class HomeSystem {
    private final AutomationController controller;

    public HomeSystem() {
        this.controller = AutomationController.getInstance();
    }

    public void activateDevice(Command command) {
        controller.initiateSystem();
        command.execute();
    }
}

// App Entry Point
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
