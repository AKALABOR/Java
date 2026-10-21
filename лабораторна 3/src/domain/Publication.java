package domain;

public abstract class Publication {
    protected String title;
    protected String author;
    protected int year;

    public Publication(String title, String author, int year) {
        this.title = title;
        this.author = author;
        this.year = year;
    }

    public abstract String describe();

    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public int getYear() { return year; }
}
