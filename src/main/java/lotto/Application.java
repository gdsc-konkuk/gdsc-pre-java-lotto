package lotto;

import lotto.config.LottoConfig;
import lotto.controller.LottoController;

public class Application {

    public static void main(String[] args) {

        LottoConfig lottoConfig=new LottoConfig();

        // config를 통해 controller에 의존성 주입
        LottoController lottoController = lottoConfig.initLottoController();

        // startGame을 통해 게임 진행
        lottoController.startGame();
    }
}
