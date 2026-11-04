package domain;

public class HolidayDiscount extends Discount {

    public HolidayDiscount(double rate) {
        super("Святкова знижка", rate);
    }

    @Override
    public double apply(double price) {
        return price - calcDiscount(price);
    }
}
