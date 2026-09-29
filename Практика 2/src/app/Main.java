package app;

import model.Sensor;
import model.ModelTester;

public class Main {
    public static void main(String[] args) {
        ModelTester.testAccess();
        
        Sensor s = new Sensor();
        System.out.println("\nПеревірка доступу з Main:");
        // System.out.println(s.identifier); // Помилка: private
        // System.out.println(s.value);      // Помилка: package-private (за замовчуванням)
        // System.out.println(s.unit);       // Помилка: protected
        System.out.println("Активний (public): " + s.isActive);

        System.out.println("\nПеревірка конструкторів:");
        Sensor s1 = new Sensor();
        Sensor s2 = new Sensor("TEMP-01", 36.6, "Celsius", true);
        Sensor s3 = new Sensor("HUM-01");

        System.out.println("ID першого датчика: " + s1.getIdentifier());
        System.out.println("ID другого датчика: " + s2.getIdentifier());
        System.out.println("ID третього датчика: " + s3.getIdentifier());

        s1.setIdentifierWithoutThis("NEW-ID-99");
        System.out.println("Після setIdentifierWithoutThis (s1): " + s1.getIdentifier());

        System.out.println("\nПеревірка static:");
        System.out.println("Кількість (через об'єкт s1) = " + Sensor.sensorCount);
        Sensor.printSensorCount();
        
        System.out.println("\nПеревірка final:");
        System.out.println("Серійний номер s1: " + s1.serialNumber);
        // s1.serialNumber = 10; // Помилка: неможливо змінити final змінну
        
        final int x = 42;
        // x = 50; // Помилка
    }
}
