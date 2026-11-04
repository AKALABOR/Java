package domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class Booking {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter
            .ofPattern("uuuu-MM-dd")
            .withResolverStyle(ResolverStyle.STRICT);

    private final String name;
    private final LocalDate date;
    private final int places;

    public Booking(String name, LocalDate date, int places) throws InvalidBookingException {
        if (name == null || name.trim().isEmpty()) {
            throw new InvalidBookingException("ім'я не може бути порожнім");
        }
        if (date == null) {
            throw new InvalidBookingException("дата не може бути порожньою");
        }
        if (places < 1 || places > 10) {
            throw new InvalidBookingException("кількість місць " + places + " поза межами 1..10");
        }
        this.name = name.trim();
        this.date = date;
        this.places = places;
    }

    public static Booking parse(String line) throws InvalidBookingException {
        if (line == null || line.trim().isEmpty()) {
            throw new InvalidBookingException("порожній рядок");
        }
        String[] parts = line.split(";", -1);
        if (parts.length != 3) {
            throw new InvalidBookingException("очікувалось 3 поля, отримано " + parts.length);
        }

        String name = parts[0].trim();
        if (name.isEmpty()) {
            throw new InvalidBookingException("ім'я не може бути порожнім");
        }

        String dateStr = parts[1].trim();
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr, DATE_FORMATTER);
        } catch (DateTimeParseException e) {
            throw new InvalidBookingException("недійсна дата \"" + dateStr + "\" (очікується yyyy-MM-dd)", e);
        }

        String placesStr = parts[2].trim();
        int places;
        try {
            places = Integer.parseInt(placesStr);
        } catch (NumberFormatException e) {
            throw new InvalidBookingException("\"" + placesStr + "\" не є числом", e);
        }

        return new Booking(name, date, places);
    }

    public String getName() {
        return name;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getPlaces() {
        return places;
    }
}
