package lotto.service;

import lotto.domain.LottoPrize;

import java.util.List;

/**
 * <h4>상금과 수익률 계산</h4>
 */
public class CalculateService {

    private double calculatePrize(List<Integer> gradeList) {
        double prize = 0;
        prize += LottoPrize.FIFTH.getPrizeAmount() * gradeList.get(0);
        prize += LottoPrize.FOURTH.getPrizeAmount() * gradeList.get(1);
        prize += LottoPrize.THIRD.getPrizeAmount() * gradeList.get(2);
        prize += LottoPrize.SECOND.getPrizeAmount() * gradeList.get(3);
        prize += LottoPrize.FIRST.getPrizeAmount() * gradeList.get(4);
        return prize;
    }

    public double calculateRateofProfit(List<Integer> gradeList, int purchaseMoney) {
        double prize = calculatePrize(gradeList);
        return (prize / (double) purchaseMoney) * 100;
    }
}
