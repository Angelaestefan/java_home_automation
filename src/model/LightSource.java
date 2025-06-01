package src.model;

public class LightSource {
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