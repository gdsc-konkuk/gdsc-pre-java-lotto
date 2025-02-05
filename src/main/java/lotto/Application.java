package lotto;

import lotto.Producer.LottoProducer;
import lotto.Product.Lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        IOSequence io=new IOSequence(new Scanner(System.in));
        User user = new User();
        // 초기 투자금 지정
        user.setPurchaseMoney(io.inputPurchaseMoney());
        Seller seller = new Seller(new LottoProducer());
        // 셀러에게 로또 구매
        user.orderToSeller(seller);
        // 구매한 로또 번호 출력
        io.outputLottoList(user.getPurchaseLottoList());
        // 당첨 번호, 보너스 번호 지정해서 객체 생성
        Lotto lt= io.inputWinningLotto();
        int bonusNum = io.inputBonusInt(lt);
        LottoGradeCheck lc=new LottoGradeCheck(lt, bonusNum);
        // 등수 확인
        user.checkLottoGrade(lc);
        // 등수 출력
        io.outputGrade(user.getGradeList());
        // 상금 계산
        user.calculatePrize();
        // 수익률 계산
        user.calculateRateofProfit();
        // 수익률 반환, 출력
        io.outputRateOfProfit(user.getRateofProfit());
    }
}
