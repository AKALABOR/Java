package app;

import domain.BasicLoyalty;
import domain.CouponDiscount;
import domain.HolidayDiscount;
import domain.PremiumLoyalty;
import domain.SeasonalDiscount;
import domain.VipDiscount;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        DiscountService s1 = new DiscountService(new SeasonalDiscount(0.15), new BasicLoyalty());
        s1.applyTo(1000.00);

        System.out.println();

        DiscountService s2 = new DiscountService(new VipDiscount(0.25), new PremiumLoyalty());
        s2.applyTo(1000.00);

        System.out.println();

        CouponDiscount coupon = new CouponDiscount(0.10, LocalDate.of(2026, 12, 31));
        DiscountService s3 = new DiscountService(coupon, new BasicLoyalty());
        s3.applyTo(1000.00);
        if (!coupon.isExpired()) {
            System.out.println("Купон дійсний до: " + coupon.getExpiryDate());
        }

        System.out.println();

        DiscountService s4 = new DiscountService(new HolidayDiscount(0.20), new PremiumLoyalty());
        s4.applyTo(1000.00);
    }
}
