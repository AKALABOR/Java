package domain;

public class Book extends Publication {
    public String label = "похідний";

    public Book(String title) {
        super(title);
        System.out.println("-> [Book] конструктор");
    }

    @Override
    public String describe() {
        return super.describe() + " (книга)";
    }
}
