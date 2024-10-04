package lotto.view;

import lotto.Model.Lotto;

public class Out {
    public void printLotto(Lotto lotto) {
        System.out.println(lotto.toString());
    }

    public void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public void printLottoCounts(Integer lottoCounts) {
        System.out.println(lottoCounts + "개를 구매했습니다.");
    }
}
