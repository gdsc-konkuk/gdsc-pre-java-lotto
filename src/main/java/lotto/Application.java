package lotto;

import java.util.List;

/*
 * Application Class
 * 1. 프로그램의 흐름 관리 (main 함수)
 * */
public class Application {

    public static void main(String[] args) {
        // 1. 구입 금액 입력
        Integer amount = IO.getAmount();

        // 2. 사용자 객체 생성
        User user = new User(amount);

        // 3. 당첨 번호 입력
        List<Integer> winningNumbers = IO.getWinLotto();
        Lotto winLotto = new Lotto(winningNumbers);

        // 4. 보너스 번호 입력
        Integer bonus = IO.getBonus(winLotto);

        // 5. 결과 출력
        IO.printResult(user.getResult(winLotto, bonus));
    }

}