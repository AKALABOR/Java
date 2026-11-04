package domain;

import java.time.LocalDate;

public class CouponDiscount extends Discount implements Expirable {
    private final LocalDate expiryDate;

    public CouponDiscount(double rate, LocalDate expiryDate) {
        super("Купон", rate);
        this.expiryDate = expiryDate;
    }

    @Override
    public double apply(double price) {
        if (isExpired()) {
            return price;
        }
        return price - calcDiscount(price);
    }

    @Override
    public boolean isExpired() {
        return LocalDate.now().isAfter(expiryDate);
    }

    @Override
    public LocalDate getExpiryDate() {
        return expiryDate;
    }
}
