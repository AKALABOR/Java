package app;

import domain.Publication;
import domain.Book;
import domain.Magazine;
import domain.Article;

public class Main {
    public static void main(String[] args) {
        Publication[] publications = {
            new Book("Кобзар", "Тарас Шевченко", 1840, 250.00),
            new Magazine("Країна", "Редакція", 2023, 47),
            new Article("Нейронні мережі в освіті", "Іван Коваль", 2024, "Науковий вісник")
        };

        for (Publication p : publications) {
            System.out.println(p.describe());
        }
    }
}
