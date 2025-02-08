package lotto.controller;

import lotto.domain.product.Lotto;
import lotto.domain.product.Product;
import lotto.service.CalculateService;
import lotto.service.DistributeService;
import lotto.service.LottoGradeCheckService;
import lotto.service.InputService;
import lotto.view.Output;

import java.util.ArrayList;
import java.util.List;
/**
 * <h4>전체적인 프로그램 흐름 제어</h4>
 * <br>
 * {@link lotto.config.LottoConfig} 를 통해 Controller 객체가 생성된 후, {@link #startGame()} 을 통해 프로그램 진행
 */
public class LottoController {

    private final LottoGradeCheckService lottoGradeCheckService;
    private final DistributeService distributeService;
    private final InputService inputService;
    private final CalculateService calculateService;
    private final Output output;

    public LottoController(LottoGradeCheckService lottoGradeCheckService, DistributeService distributeService, InputService inputService, CalculateService calculateService, Output output) {
        this.lottoGradeCheckService = lottoGradeCheckService;
        this.distributeService = distributeService;
        this.inputService = inputService;
        this.calculateService = calculateService;
        this.output = output;
    }

    public void startGame(){
        // 초기 투자금 지정
        int purchaseMoney;
        try{
            purchaseMoney = inputService.inputPurchaseMoney();
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR]잘못된 입력입니다. 프로그램을 종료합니다.");
            return;
        }
        int purchaseLottoCount= purchaseMoney / 1000;
        // 구매 수량으로 Lotto 구매
        List<Product> purchaseProduct = distributeService.orderToSeller(purchaseLottoCount);
        List<Lotto> purchaseLottos = new ArrayList<>();
        for (Product product : purchaseProduct) {
            purchaseLottos.add((Lotto) product);
        }

        // 구매한 로또 번호 출력
        output.outputLottoList(purchaseLottos);
        // 당첨 번호, 보너스 번호 지정해서 객체 생성
        Lotto prizeLotto= inputService.inputWinningLotto();
        int bonusNum = inputService.inputBonusInt(prizeLotto);
        endGame(purchaseLottos, prizeLotto, bonusNum, purchaseMoney);
    }

    private void endGame(List<Lotto> purchaseLottos, Lotto prizeLotto, int bonusNum, int purchaseMoney){
        // 등수 확인
        List<Integer> gradeList=lottoGradeCheckService.checkGrade(prizeLotto,bonusNum,purchaseLottos);
        // 등수 출력
        output.outputGrade(gradeList);
        // 수익률 계산
        double RateOfProfit = calculateService.calculateRateofProfit(gradeList, purchaseMoney);
        // 수익률 반환, 출력
        output.outputRateOfProfit(RateOfProfit);

    }
}
