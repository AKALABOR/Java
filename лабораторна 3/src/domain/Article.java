package domain;

public class Article extends Publication {
    private String journal;

    public Article(String title, String author, int year, String journal) {
        super(title, author, year);
        this.journal = journal;
    }

    @Override
    public String describe() {
        return "Стаття: \"" + title + "\" (" + author + ", " + year + " р.) // " + journal;
    }
}
