package lotto.view;

import lotto.domain.product.Lotto;

import java.util.List;
/**
 * <h4>결과 출력</h4>
 */
public class Output {
    public void outputLottoList(List<Lotto> lottoList){
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
    public void outputGrade(List<Integer> gradeList){
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", gradeList.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", gradeList.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", gradeList.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", gradeList.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", gradeList.get(4));
    }
    public void outputRateOfProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%%s", profit, "입니다.");
    }
}
