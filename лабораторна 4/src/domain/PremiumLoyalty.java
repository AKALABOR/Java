package domain;

public class PremiumLoyalty implements LoyaltyProgram {

    @Override
    public double getBonus(double price) {
        return price * 0.07;
    }

    @Override
    public String getProgramName() {
        return "Преміум лояльність (7%)";
    }
}
