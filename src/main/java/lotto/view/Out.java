package lotto.view;

import lotto.Model.Lotto;

/*
 * Out Class
 * 1. 프로그램의 모든 출력을 관리함
 * */

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
