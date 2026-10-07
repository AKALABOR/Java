package domain;

public class Publication {
    public String label = "базове";
    protected String title;

    public Publication(String title) {
        System.out.println("-> [Publication] конструктор");
        this.title = title;
    }

    public String describe() {
        return "публікація '" + title + "'";
    }
}
