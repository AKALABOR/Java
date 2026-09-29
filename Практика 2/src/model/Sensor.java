package model;

public class Sensor {
    private String identifier = "unknown";
    double value = 0.0;
    protected String unit = "N/A";
    public boolean isActive = false;

    public static int sensorCount = 0;
    public final int serialNumber;

    public Sensor() {
        this.identifier = "default_id";
        this.value = 25.5;
        this.unit = "Celsius";
        this.isActive = true;
        
        sensorCount++;
        this.serialNumber = sensorCount;
    }

    public Sensor(String identifier, double value, String unit, boolean isActive) {
        this.identifier = identifier;
        this.value = value;
        this.unit = unit;
        this.isActive = isActive;
        
        sensorCount++;
        this.serialNumber = sensorCount;
    }

    public Sensor(String identifier) {
        this(identifier, 0.0, "Unknown", false);
    }

    public void setIdentifierWithoutThis(String identifier) {
        identifier = identifier; 
    }
    
    public String getIdentifier() {
        return identifier;
    }

    public static void printSensorCount() {
        System.out.println("Total sensors created: " + sensorCount);
    }
}
