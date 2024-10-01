package lotto;

public enum Rank {
    NONE(0L, false, 0, "꽝"),
    FIFTH(3L, false, 5000, "3개 일치 (5,000원)"),
    FOURTH(4L, false, 50000, "4개 일치 (50,000원)"),
    THIRD(5L, false, 1500000, "5개 일치 (1,500,000원)"),
    SECOND(5L, true, 30000000, "5개 일치, 보너스 볼 일치 (30,000,000원)"),
    FIRST(6L, false,2000000000, "6개 일치 (2,000,000,000원)");


    private final Long matchCount;
    private final boolean bonus;
    private final Integer prizeMoney;
    private final String description;

    Rank(Long matchCount, boolean bonus, Integer prizeMoney, String description) {
        this.matchCount = matchCount;
        this.bonus = bonus;
        this.prizeMoney = prizeMoney;
        this.description = description;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public String getDescription() {
        return description;
    }

    public static Rank getRank(Long matchCount, boolean bonusMatched) {
        if (matchCount == 6) { return FIRST; }
        if (matchCount == 5 && bonusMatched) { return SECOND; }
        if (matchCount == 5) { return THIRD; }
        if (matchCount == 4) { return FOURTH; }
        if (matchCount == 3) { return FIFTH; }
        return NONE;
    }

}
