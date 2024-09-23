package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        // 1. 구입 금액 입력
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

        // 2. 사용자 객체 생성
        User user = new User(amount);

        // 3. 당첨 번호 입력
        Lotto winLotto = null;
        while(winLotto == null){
            try {
                System.out.println("당첨 번호를 입력해주세요.");
                String userInputForWinnings = Console.readLine();
                winLotto = makeWinningLotto(userInputForWinnings);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(winLotto);

        // 4. 보너스 번호 입력
        Integer bonus = null;
        while(bonus == null){
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                int input = Integer.parseInt(Console.readLine());
                validateLottoNumber(input);
                winLotto.validateBonus(input);
                bonus = input;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 입력값은 정수가 아닙니다.");
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println(bonus);

        // 5. 결과 출력
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println(user.getResultString(winLotto, bonus));
    }

    private static void validateAmount(int amount) {
        if (amount < 1000 || amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }

    private static Lotto makeWinningLotto(String userInputForWinnings) throws NumberFormatException {
        String[] splited = userInputForWinnings.split(",");
        if(splited.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호는 ,(comma)로 구분된 6개의 숫자로 입력해주세요.");
        }
        Set<Integer> numberSet = new HashSet<>();
        for(String s: splited){
            Integer integer = Integer.parseInt(s);
            validateLottoNumber(integer);
            numberSet.add(integer);
        }
        return new Lotto(numberSet.stream().sorted().toList());
    }

    private static void validateLottoNumber(Integer integer){
        if(integer < 1 || integer > 45){
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 정수를 입력해주세요.");
        }
    }


}
