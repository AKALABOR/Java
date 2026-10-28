package domain;

public class SequentialGenerator implements NumberGenerator {
    private int counter = 1;

    @Override
    public String generate() {
        return String.valueOf(counter++);
    }
}
