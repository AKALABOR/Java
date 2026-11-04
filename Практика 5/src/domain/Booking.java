package domain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

public class Booking {
    private final String clientName;
    private final int places;

    public Booking(String clientName, int places) {
        this.clientName = clientName;
        this.places = places;
    }

    public static int parsePlacesWithCause(String input) throws InvalidBookingException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidBookingException("Некоректні дані бронювання: " + input, e);
        }
    }

    public static int parsePlacesWithoutCause(String input) throws InvalidBookingException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new InvalidBookingException(e.getMessage());
        }
    }

    public String getInfo() {
        return "Бронювання: " + clientName + ", місць: " + places;
    }
}

