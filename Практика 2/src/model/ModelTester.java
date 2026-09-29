package model;

public class ModelTester {
    public static void testAccess() {
        Sensor sensor = new Sensor();
        System.out.println("Перевірка доступу з ModelTester:");
        
        // System.out.println(sensor.identifier); // Помилка: has private access
        System.out.println("Значення (default): " + sensor.value);
        System.out.println("Одиниця виміру (protected): " + sensor.unit);
        System.out.println("Активний (public): " + sensor.isActive);
    }
}
