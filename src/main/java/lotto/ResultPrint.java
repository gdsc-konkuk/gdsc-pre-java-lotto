package lotto;

public class ResultPrint {

    public void Print(int count) {
        double profitRate=Calculate(count);
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", LottoRank.FIFTH.getCount());
        System.out.printf("4개 일치 (50,000원) - %d개\n", LottoRank.FOURTH.getCount());
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", LottoRank.THIRD.getCount());
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", LottoRank.SECOND.getCount());
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", LottoRank.FIRST.getCount());

        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }
    private double Calculate(int count) {
        long totalProfit = (long) LottoRank.FIFTH.getCount() * LottoRank.FIFTH.getPrize() +
                (long) LottoRank.FOURTH.getCount() * LottoRank.FOURTH.getPrize() +
                (long) LottoRank.THIRD.getCount() * LottoRank.THIRD.getPrize() +
                (long) LottoRank.SECOND.getCount() * LottoRank.SECOND.getPrize() +
                (long) LottoRank.FIRST.getCount() * LottoRank.FIRST.getPrize();
        long investment = count * 1000L;
        return (double) totalProfit / investment * 100;
    }
}
