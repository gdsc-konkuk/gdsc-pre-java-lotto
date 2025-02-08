package lotto.config;


import lotto.controller.LottoController;
import lotto.domain.Seller;
import lotto.domain.producer.LottoProducer;
import lotto.domain.producer.Producer;
import lotto.service.CalculateService;
import lotto.service.DistributeService;
import lotto.service.ValidationService;
import lotto.service.LottoGradeCheckService;
import lotto.service.InputService;
import lotto.view.Output;

import java.util.Scanner;

/**
 * <h4>로또 프로그램 실행을 위해 의존성 주입</h4>
 */
public class LottoConfig {

    public LottoController initLottoController() {
        Producer producer = getLottoProducer();
        Seller seller = getSeller(producer);
        DistributeService distributeService = getDistributeService(seller);
        LottoGradeCheckService lottoGradeCheckService = getLottoGradeCheckService();
        InputService inputService = getIOSequence();
        CalculateService calculateService = getCalculateService();
        Output output = getOutput();
        return new LottoController(lottoGradeCheckService, distributeService, inputService, calculateService, output);
    }

    private Output getOutput() {
        return new Output();
    }

    private static CalculateService getCalculateService() {
        return new CalculateService();
    }

    private static InputService getIOSequence() {
        return new InputService(getValidationService(), new Scanner(System.in));
    }

    private static DistributeService getDistributeService(Seller seller) {
        return new DistributeService(seller);
    }

    private static LottoGradeCheckService getLottoGradeCheckService() {
        return new LottoGradeCheckService();
    }

    private static ValidationService getValidationService() {
        return new ValidationService();
    }

    private Producer getLottoProducer() {
        return new LottoProducer();
    }

    private Seller getSeller(Producer producer) {
        return new Seller(producer);
    }
}