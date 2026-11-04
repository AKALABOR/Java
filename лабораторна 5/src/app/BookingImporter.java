package app;

import domain.Booking;
import domain.BookingReport;
import domain.InvalidBookingException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class BookingImporter {
    public static void process(String inputPath, String outputPath) {
        File inputFile = new File(inputPath);
        if (!inputFile.exists() || !inputFile.isFile()) {
            System.out.println("Помилка: файл " + inputPath + " не знайдено");
            return;
        }

        BookingReport report = new BookingReport();
        int importedCount = 0;
        int rejectedCount = 0;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                new FileInputStream(inputFile), StandardCharsets.UTF_8))) {

            String header = reader.readLine();
            if (header == null) {
                System.out.println("Помилка: файл " + inputPath + " порожній");
                return;
            }

            String line;
            int lineNumber = 1;

            while ((line = reader.readLine()) != null) {
                lineNumber++;
                try {
                    Booking booking = Booking.parse(line);
                    report.add(booking);
                    importedCount++;
                } catch (InvalidBookingException e) {
                    rejectedCount++;
                    System.out.println("Рядок " + lineNumber + ": " + e.getMessage());
                }
            }

        } catch (IOException e) {
            System.out.println("Помилка читання файлу " + inputPath + ": " + e.getMessage());
            return;
        }

        File outputFile = new File(outputPath);
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(outputFile), StandardCharsets.UTF_8))) {
            writer.write(report.generateSummary());
        } catch (IOException e) {
            System.out.println("Помилка запису у файл " + outputPath + ": " + e.getMessage());
            return;
        }

        System.out.println("Імпортовано: " + importedCount + ", відхилено: " + rejectedCount + ". Звіт записано у " + outputPath);
    }
}
