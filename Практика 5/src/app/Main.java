package app;

import domain.Booking;
import domain.InvalidBookingException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {

        testCheckedAndUncheckedExceptions();
        System.out.println();

        testCustomExceptionWithoutCause();
        System.out.println();

        testCustomExceptionWithCause();
        System.out.println();

        testFileWritingAndEncoding();
    }

    private static void testCheckedAndUncheckedExceptions() {
        System.out.println("Тестування винятків:");
        try {
            FileReader reader = new FileReader("missing_booking.txt");
            reader.read();
        } catch (IOException e) {
            System.out.println("Перехоплено перевірюваний виняток: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Блок finally виконано після перевірюваного винятку");
        }

        try {
            int result = 10 / 0;
            System.out.println("Результат: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Перехоплено неперевірюваний виняток: " + e.getClass().getSimpleName());
        } finally {
            System.out.println("Блок finally виконано після неперевірюваного винятку");
        }
    }

    private static void testCustomExceptionWithoutCause() {
        System.out.println("Власний виняток без причини:");
        try {
            Booking.parsePlacesWithoutCause("дві_особи");
        } catch (InvalidBookingException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void testCustomExceptionWithCause() {
        System.out.println("Власний виняток зі збереженням причини:");
        try {
            Booking.parsePlacesWithCause("дві_особи");
        } catch (InvalidBookingException e) {
            e.printStackTrace(System.out);
        }
    }

    private static void testFileWritingAndEncoding() {
        System.out.println("Робота з файлами та кодуванням:");

        File unclosedFile = new File("bookings_unclosed.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(unclosedFile), StandardCharsets.UTF_8));
            writer.write("Бронювання №101: Готель Дніпро, 2 місця");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
        System.out.println("Розмір незакритого файлу: " + unclosedFile.length() + " байт");

        File file = new File("bookings.txt");
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), StandardCharsets.UTF_8))) {
            writer.write("Бронювання №101: Готель Дніпро, 2 місця");
            writer.newLine();
            writer.write("Бронювання №102: Апартаменти Львів, 1 місце");
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Помилка запису: " + e.getMessage());
        }
        System.out.println("Розмір файлу після закриття: " + file.length() + " байт");

        System.out.println("Читання у кодуванні UTF-8:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), StandardCharsets.UTF_8))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }

        System.out.println("Читання у кодуванні Windows-1251:");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(file), Charset.forName("windows-1251")))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Помилка читання: " + e.getMessage());
        }
    }
}