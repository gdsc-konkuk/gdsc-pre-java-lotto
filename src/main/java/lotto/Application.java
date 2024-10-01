package lotto;

import java.util.*;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 1. 구입 금액 입력
        Integer amount = getAmount();

        // 2. 사용자 객체 생성
        User user = new User(amount);

        // 3. 당첨 번호 입력
        Lotto winLotto = getWinLotto();

        // 4. 보너스 번호 입력
        Integer bonus = getBonus(winLotto);

        // 5. 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(user.getResultString(winLotto, bonus));
    }

    private static Integer getBonus(Lotto winLotto) {
        Integer bonus = null;
        while (bonus == null) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                Lotto.validateLottoNumber(input);
                winLotto.validateBonus(input);
                bonus = input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(bonus);
        return bonus;
    }

    private static Lotto getWinLotto() {
        Lotto winLotto = null;
        while (winLotto == null) {
            try {
                System.out.println("당첨 번호를 입력해주세요.");
                String userInputForWinnings = Console.readLine();
                winLotto = new Lotto(userInputForWinnings);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(winLotto);
        return winLotto;
    }

    private static Integer getAmount() {
        Integer amount = null;
        while (amount == null) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                validateAmount(input);
                amount = input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return amount;
    }

    private static void validateAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }


}
