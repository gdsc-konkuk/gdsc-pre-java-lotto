package lotto.domain;

public enum LottoPrize {
    FIRST(2_000_000_000.0),
    SECOND(50_000_000.0),
    THIRD(1_500_000.0),
    FOURTH(450_000.0),
    FIFTH(5_000.0);

    private final double prizeAmount;

    LottoPrize(double prizeAmount) {
        this.prizeAmount = prizeAmount;
    }

    public double getPrizeAmount() {
        return prizeAmount;
    }
}