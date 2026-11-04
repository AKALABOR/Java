package domain;

public abstract class Discount implements DiscountStrategy {
    protected final String name;
    protected final double rate;

    public Discount(String name, double rate) {
        this.name = name;
        this.rate = rate;
    }

    @Override
    public String getName() {
        return name;
    }

    protected double calcDiscount(double price) {
        return price * rate;
    }
}
