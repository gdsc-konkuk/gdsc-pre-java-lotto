package lotto;

import lotto.Product.Lotto;
import lotto.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class User {
    private int purchaseMoney;
    private List<Lotto> purchaseLottoList;
    private List<Integer> gradeList;
    private double prize;
    private double rateOfProfit;

    public User() {
        prize = 0.0;
    }

    public void orderToSeller(Seller seller) {// 셀러에게, 구매시퀀스 동작
        List<Product> lottoList=seller.orderSequence(this.purchaseMoney / 1000, this);
        this.purchaseLottoList = new ArrayList<>();
        for (Product product:lottoList) {
            this.purchaseLottoList.add((Lotto) product);
        }

    }

    public void checkLottoGrade(LottoGradeCheck lottoGradeCheck) {
        this.gradeList=lottoGradeCheck.checkGrade(purchaseLottoList);
    }

    public void calculatePrize() {
        prize += LottoPrize.FIFTH.getPrizeAmount() * gradeList.get(0);
        prize += LottoPrize.FOURTH.getPrizeAmount() * gradeList.get(1);
        prize += LottoPrize.THIRD.getPrizeAmount() * gradeList.get(2);
        prize += LottoPrize.SECOND.getPrizeAmount() * gradeList.get(3);
        prize += LottoPrize.FIRST.getPrizeAmount() * gradeList.get(4);
    }

    public void calculateRateofProfit() {
        rateOfProfit = (prize / (double) purchaseMoney) * 100;
    }

    public List<Integer> getGradeList() {
        return gradeList;
    }

    public List<Lotto> getPurchaseLottoList() {
        return purchaseLottoList;
    }

    public double getRateofProfit() {
        return rateOfProfit;
    }

    public void setPurchaseMoney(int purchaseMoney) {
        this.purchaseMoney = purchaseMoney;
    }


}
