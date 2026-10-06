package domain;

public class Book {
    private static int nextId = 1;
    public final int id;
    private final String title;
    private final String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Назва книги не може бути порожньою");
        }
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Автор не може бути порожнім");
        }
        
        this.id = nextId++;
        this.title = title;
        this.author = author;
        setYear(year);
        setPrice(price);
    }

    public Book(String title, String author) {
        this(title, author, 2024, 0.0);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1000 || year > 2100) {
            throw new IllegalArgumentException("Некоректний рік видання: " + year);
        }
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new IllegalArgumentException("Ціна не може бути від'ємною");
        }
        this.price = price;
    }

    @Override
    public String toString() {
        return String.format("Книга #%d: '%s' (%s), %d рік - %.2f грн", id, title, author, year, price);
    }
}
