package domain;

public class Magazine extends Publication {
    private int issue;

    public Magazine(String title, String author, int year, int issue) {
        super(title, author, year);
        this.issue = issue;
    }

    @Override
    public String describe() {
        return "Журнал: \"" + title + "\" №" + issue + " (" + author + ", " + year + " р.)";
    }
}
