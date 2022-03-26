package theorigin.javaspringboot.client.model;

public class ActuatorLoggerDTO {

    private String configuredLevel;

    public ActuatorLoggerDTO() {
    }

    public ActuatorLoggerDTO(String configuredLevel) {
        this.configuredLevel = configuredLevel;
    }

    public String getConfiguredLevel() {
        return configuredLevel;
    }

    public void setConfiguredLevel(String configuredLevel) {
        this.configuredLevel = configuredLevel;
    }

    @Override
    public String toString() {
        return "ActuatorLoggerDto{" +
                "configuredLevel='" + configuredLevel + '\'' +
                '}';
    }
}
