package lotto;

public enum LottoRank {
    FIRST(1, "1등", 2_000_000_000),
    SECOND(2, "2등", 50_000_000),
    THIRD(3, "3등", 1_500_000),
    FOURTH(4, "4등", 50_000),
    FIFTH(5, "5등", 5_000);

    private final int rank;
    private final String name;
    private final int prize;
    private int count; // 각 등수의 개수를 저장할 필드

    LottoRank(int rank, String name, int prize) {
        this.rank = rank;
        this.name = name;
        this.prize = prize;
        this.count = 0;
    }

    public void incrementCount() {
        this.count++;
    }


    public int getCount() {
        return count;
    }

    public int getRank() {
        return rank;
    }

    public int getPrize() {
        return prize;
    }

    // rank에 해당하는 LottoRank enum 상수를 반환하는 메서드
    public static LottoRank valueOfRank(int rank) {
        for (LottoRank lottoRank : values()) {
            if (lottoRank.getRank() == rank) {
                return lottoRank;
            }
        }
        throw new IllegalArgumentException("해당 등수가 없습니다: " + rank);
    }

    @Override
    public String toString() {
        return String.valueOf(count);
    }
}
