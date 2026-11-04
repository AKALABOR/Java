package domain;

public class VipDiscount extends Discount {

    public VipDiscount(double rate) {
        super("VIP знижка", rate);
    }

    @Override
    public double apply(double price) {
        return price - calcDiscount(price);
    }
}
