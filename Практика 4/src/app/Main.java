package app;

import domain.Animal;
import domain.Bird;
import domain.Fish;
import domain.Movable;
import domain.Feedable;
import domain.NumberGenerator;
import domain.SequentialGenerator;
import domain.PrefixGenerator;

public class Main {
    public static void main(String[] args) {

        Bird bird = new Bird("Горобець");
        Fish fish = new Fish("Карась");

        System.out.println(bird.move());
        System.out.println(bird.eat());
        System.out.println(fish.move());
        System.out.println(fish.eat());

        Movable m = bird;
        System.out.println(m.move());

        Feedable f = bird;
        System.out.println(f.feed());

        System.out.println(bird.describe());

        NumberService sequential = new NumberService(new SequentialGenerator());
        System.out.println("Послідовний:");
        sequential.printNext(3);

        NumberService prefixed = new NumberService(new PrefixGenerator("ID"));
        System.out.println("З префіксом:");
        prefixed.printNext(3);
    }
}
