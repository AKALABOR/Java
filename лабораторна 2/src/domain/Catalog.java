package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Catalog {
    private final String name;
    private final List<Book> books;
    private int totalPositions;
    private double totalPrice;

    public Catalog(String name) {
        this.name = name;
        this.books = new ArrayList<>();
        this.totalPositions = 0;
        this.totalPrice = 0.0;
    }

    public boolean addBook(Book book) {
        if (book == null) {
            return false;
        }
        
        books.add(book);
        updateStatistics(book);
        return true;
    }

    private void updateStatistics(Book newBook) {
        this.totalPositions = books.size();
        this.totalPrice += newBook.getPrice();
    }

    public String getName() {
        return name;
    }

    public int getTotalPositions() {
        return totalPositions;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }

    public List<Book> getBooks() {
        return Collections.unmodifiableList(books);
    }
    
    public void printCatalog() {
        System.out.println("Каталог '" + name + "'");
        for (Book b : books) {
            System.out.println("+ " + b.toString());
        }
        System.out.println("Всього позицій: " + totalPositions);
    }
}
