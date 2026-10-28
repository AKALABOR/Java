package domain;

public class Fish extends Animal implements Movable, Feedable {

    public Fish(String name) {
        super(name);
    }

    @Override
    public String move() {
        return name + " пливе";
    }

    @Override
    public String feed() {
        return name + " ковтає мотиля";
    }

    @Override
    public String describe() {
        return Movable.super.describe() + " | " + Feedable.super.describe();
    }
}
