package domain;

public abstract class Animal {
    protected String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract String move();

    public String eat() {
        return name + " їсть";
    }
}
