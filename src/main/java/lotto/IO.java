package lotto;

import camp.nextstep.edu.missionutils.Console;

public class IO {

    public static Integer getAmount() {
        Integer amount = null;
        while (amount == null) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                if (input < 1000 || input % 1000 != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
                }
                amount = input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
        return amount;
    }

    public static Lotto getWinLotto() {
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

    public static Integer getBonus(Lotto winLotto) {
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

    public static void printResult(String result){
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printUserConstructed(Integer lottoCounts, User user){
        System.out.println(lottoCounts + "개를 구매했습니다.");
        System.out.println(user);
    }
}
