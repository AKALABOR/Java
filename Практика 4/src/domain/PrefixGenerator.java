package domain;

public class PrefixGenerator implements NumberGenerator {
    private int counter = 1;
    private final String prefix;

    public PrefixGenerator(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public String generate() {
        return prefix + "-" + counter++;
    }
}
