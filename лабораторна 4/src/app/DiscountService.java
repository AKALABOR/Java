package app;

import domain.DiscountStrategy;
import domain.LoyaltyProgram;

public class DiscountService {
    private final DiscountStrategy discount;
    private final LoyaltyProgram loyalty;

    public DiscountService(DiscountStrategy discount, LoyaltyProgram loyalty) {
        this.discount = discount;
        this.loyalty = loyalty;
    }

    public void applyTo(double price) {
        double discounted = discount.apply(price);
        double bonus = loyalty.getBonus(discounted);
        System.out.printf("[%s] %.2f грн -> %.2f грн%n", discount.getName(), price, discounted);
        System.out.printf("[%s] бонус: +%.2f грн%n", loyalty.getProgramName(), bonus);
    }
}
