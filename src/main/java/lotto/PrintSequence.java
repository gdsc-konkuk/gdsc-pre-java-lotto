package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintSequence {
    private List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));//3,4,5,6,5+bonus
    private List<Lotto> buy;
    private double profitRate;

    public PrintSequence(List<Integer> result, List<Lotto> buy) {
        this.result = result;
        this.buy = buy;
    }
    public void ResultPrint() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(4));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(3));

        System.out.printf("총 수익률은 %.0f%%입니다.", profitRate);
    }
    public double Calculate() {
        long totalProfit = result.get(0) * 5000L +
                result.get(1) * 50000L +
                result.get(2) * 1500000L +
                result.get(4) * 30000000L +
                result.get(3) * 2000000000L;
        long investment = buy.size() * 1000L;
        double profitRate = (double) totalProfit / investment * 100;
        return profitRate;
    }
}
