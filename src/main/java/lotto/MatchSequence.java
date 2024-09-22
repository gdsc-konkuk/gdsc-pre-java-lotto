package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MatchSequence {

    private List<Integer> prizeNum;
    private int bonus;
    private List<Lotto> buy;
    private List<Integer> result = new ArrayList<>(Collections.nCopies(5, 0));//3,4,5,6,5+bonus

    public MatchSequence(List<Integer> prizeNum, int bonus, List<Lotto> buy) {
        this.prizeNum = prizeNum;
        this.bonus = bonus;
        this.buy = buy;
    }

    public void start() {
        Collections.sort(prizeNum);
        for (Lotto lotto : buy) {
            Collections.sort(lotto.getNumbers());
            MatchCalculator(lotto);
        }
        ResultPrint();
    }

    private void MatchCalculator(Lotto lt) {
        int prizeindex = 0, buyindex = 0, correctCount = 0;
        while (prizeindex < prizeNum.size() && buyindex < lt.getNumbers().size()) {
            if (prizeNum.get(prizeindex).equals(lt.getNumbers().get(buyindex))) {
                correctCount++;
                prizeindex++;
                buyindex++;
            } else if (prizeNum.get(prizeindex) < lt.getNumbers().get(buyindex)) prizeindex++;
            else if(prizeNum.get(prizeindex) > lt.getNumbers().get(buyindex)) buyindex++;
        }
        if (correctCount == 5) {
            MatchBonusCalculator(lt);
        } else if (correctCount > 2) {
            result.set(correctCount - 3, result.get(correctCount - 3) + 1);
        }
    }

    private void MatchBonusCalculator(Lotto lt) {
        if (lt.getNumbers().contains(bonus)) {
            result.set(4, result.get(4) + 1);
        } else {
            result.set(2, result.get(2) + 1);
        }
    }

    private void ResultPrint() {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", result.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", result.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", result.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", result.get(4));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", result.get(3));

        long totalProfit = result.get(0) * 5000L +
                result.get(1) * 50000L +
                result.get(2) * 1500000L +
                result.get(4) * 30000000L +
                result.get(3) * 2000000000L;
        long investment = buy.size() * 1000L;
        double profitRate = (double) totalProfit / investment * 100;

        System.out.printf("총 수익률은 %.0f%%입니다.", profitRate);
    }
}