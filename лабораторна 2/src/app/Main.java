package app;

import domain.Book;
import domain.Catalog;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = new Catalog("Програмування");
        
        Book b1 = new Book("Java: The Complete Reference", "Herbert Schildt", 2021, 1500.00);
        Book b2 = new Book("Effective Java", "Joshua Bloch", 2018, 1200.50);
        Book b3 = new Book("Clean Code", "Robert C. Martin"); 
        
        b3.setPrice(950.00); 
        
        catalog.addBook(b1);
        catalog.addBook(b2);
        catalog.addBook(b3);
        
        catalog.printCatalog();
        
        System.out.println();
        
        try {
            List<Book> books = catalog.getBooks();
            books.add(new Book("Hacked Book", "Hacker", 2025, 0));
        } catch (UnsupportedOperationException e) {
            System.out.println("спроба змінити перелік книг ззовні -> на каталог не впливає, Всього позицій: " + catalog.getTotalPositions());
        }
        
        boolean added = catalog.addBook(null);
        if (!added) {
            System.out.println("спроба додати порожню книгу (null) -> відхилено");
        }
        
        try {
            b1.setPrice(-100);
        } catch (IllegalArgumentException e) {
            System.out.println("спроба встановити від'ємну ціну -100 -> відхилено");
        }
    }
}
