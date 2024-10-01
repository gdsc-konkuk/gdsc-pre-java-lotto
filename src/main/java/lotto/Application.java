package lotto;

import camp.nextstep.edu.missionutils.Console;

/*
 * Application Class
 * 1. 프로그램의 흐름의 전체적인 관리 (main 함수)
 * 2. User Interface (I/O 처리)
 * */
public class Application {

    public static void main(String[] args) {
        // 1. 구입 금액 입력 및 사용자 객체 생성
        User user = getUser();

        // 3. 당첨 번호 입력
        Lotto winLotto = getWinLotto();

        // 4. 보너스 번호 입력
        Integer bonus = getBonus(winLotto);

        // 5. 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(user.getResult(winLotto, bonus));
    }

    private static User getUser() {
        User user = null;
        while (user == null) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                user = new User(input);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
        return user;
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
}