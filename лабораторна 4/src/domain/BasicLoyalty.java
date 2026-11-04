package domain;

public class BasicLoyalty implements LoyaltyProgram {

    @Override
    public double getBonus(double price) {
        return price * 0.03;
    }

    @Override
    public String getProgramName() {
        return "Базова лояльність (3%)";
    }
}
