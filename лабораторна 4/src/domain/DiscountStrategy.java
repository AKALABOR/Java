package domain;

public interface DiscountStrategy {
    double apply(double price);
    String getName();
}
