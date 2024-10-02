package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

/*
 * IO Class
 * 1. Input/Output의 관리
 * */
public class IO {

    public static Integer getAmount() {
        Integer amount = null;
        while (amount == null) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                Validation.inputAmount(input);
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

    public static List<Integer> getWinLotto() {
        List<Integer> winLotto = null;
        while (winLotto == null) {
            try {
                System.out.println("당첨 번호를 입력해주세요.");
                String userInputForWinnings = Console.readLine();
                winLotto = parseInputForWinnings(userInputForWinnings);
                Validation.lottoNumbers(winLotto);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winLotto;
    }

    public static List<Integer> parseInputForWinnings(String str) throws NumberFormatException{
        return Arrays.stream(str.split(","))
                .map(s -> Integer.parseInt(s.trim())).toList();
    }

    public static Integer getBonus(Lotto winLotto) {
        Integer bonus = null;
        while (bonus == null) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                Validation.lottoNumberRange(input);
                Validation.bonusNumber(winLotto, input);
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

    public static void printLotto(String lotto) {
        System.out.println(lotto);
    }

    public static void printResult(String result) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(result);
    }

    public static void printLottoCounts(Integer lottoCounts) {
        System.out.println(lottoCounts + "개를 구매했습니다.");
    }
}
