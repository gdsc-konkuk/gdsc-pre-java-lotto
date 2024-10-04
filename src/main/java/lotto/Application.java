package lotto;

import lotto.Model.Lotto;
import lotto.Model.User;
import lotto.controller.Controller;
import lotto.view.In;
import lotto.view.Out;

import java.util.List;

/*
 * Application Class
 * 1. Controller 객체를 생성하고 실행시켜 프로그램을 관리
 * */
public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new In(), new Out());
        controller.run();
    }

}