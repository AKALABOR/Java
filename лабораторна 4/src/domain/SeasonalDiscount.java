package domain;

public class SeasonalDiscount extends Discount {

    public SeasonalDiscount(double rate) {
        super("Сезонна знижка", rate);
    }

    @Override
    public double apply(double price) {
        return price - calcDiscount(price);
    }
}
