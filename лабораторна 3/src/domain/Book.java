package domain;

public class Book extends Publication {
    private double price;

    public Book(String title, String author, int year, double price) {
        super(title, author, year);
        this.price = price;
    }

    @Override
    public String describe() {
        return "Книга: \"" + title + "\" (" + author + ", " + year + " р.) — " + price + " грн";
    }
}
