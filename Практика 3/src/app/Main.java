package app;

import domain.Publication;
import domain.Book;

public class Main {
    public static void main(String[] args) {
        System.out.println("new Book(\"Щось 1\")");
        Book d = new Book("Щось 1");
        
        System.out.println("\nPublication b = new Book(\"Щось 2\");");
        Publication b = new Book("Щось 2");
        
        System.out.println("b.label -> \"" + b.label + "\"");
        System.out.println("b.describe() -> \"" + b.describe() + "\"");
    }
}
