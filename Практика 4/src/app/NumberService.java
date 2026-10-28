package app;

import domain.NumberGenerator;

public class NumberService {
    private final NumberGenerator generator;

    public NumberService(NumberGenerator generator) {
        this.generator = generator;
    }

    public void printNext(int count) {
        for (int i = 0; i < count; i++) {
            System.out.println(generator.generate());
        }
    }
}
