package domain;

public class BookingReport {
    private int count = 0;
    private int totalPlaces = 0;

    public void add(Booking booking) {
        count++;
        totalPlaces += booking.getPlaces();
    }

    public int getCount() {
        return count;
    }

    public int getTotalPlaces() {
        return totalPlaces;
    }

    public String generateSummary() {
        return "Кількість бронювань: " + count + System.lineSeparator() +
               "Загальна кількість місць: " + totalPlaces + System.lineSeparator();
    }
}
