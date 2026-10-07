package domain;

public class Magazine extends Publication {
    public String label = "похідний (журнал)";

    public Magazine(String title) {
        super(title);
        System.out.println("-> [Magazine] конструктор");
    }

    @Override
    public String describe() {
        return super.describe() + " (журнал)";
    }
}
