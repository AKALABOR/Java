package domain;

public class Bird extends Animal implements Movable, Feedable {

    public Bird(String name) {
        super(name);
    }

    @Override
    public String move() {
        return name + " летить";
    }

    @Override
    public String feed() {
        return name + " клює зерно";
    }

    @Override
    public String describe() {
        return Movable.super.describe() + " | " + Feedable.super.describe();
    }
}
