package domain;

public interface Movable {
    String move();

    default String describe() {
        return "Movable: об'єкт вміє рухатися";
    }
}
