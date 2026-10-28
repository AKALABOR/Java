package domain;

public interface Feedable {
    String feed();

    default String describe() {
        return "Feedable: об'єкт вміє їсти";
    }
}
