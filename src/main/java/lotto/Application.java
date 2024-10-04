package lotto;

import lotto.Model.Lotto;
import lotto.Model.User;
import lotto.controller.Controller;
import lotto.view.In;
import lotto.view.Out;

import java.util.List;

/*
 * Application Class
 * 1. 프로그램의 흐름 관리 (main 함수)
 * */
public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new In(), new Out());
        controller.run();
    }

}