package lotto.service;

import lotto.domain.product.Lotto;

import java.util.List;
import java.util.Scanner;

/**
 * <h4>유저 입력 담당</h4>
 *<br>
 * 당첨 번호 입력을 제외한 모든 입력에 대한 유효성은 {@link #validationService} 가 담당함
 */
public class InputService {
    private final ValidationService validationService;
    private Scanner sc;

    public InputService(ValidationService validationService, Scanner sc) {
        this.validationService = validationService;
        this.sc = sc;
    }

    public int inputPurchaseMoney() {
        int input = 0;
        System.out.println("구입금액을 입력해 주세요.");
        String s = sc.nextLine();
        return validationService.purchaseMoneyValidate(s);
    }

    public Lotto inputWinningLotto() {
        boolean isValid = false;
        Lotto prize = null;
        while (!isValid) {
            System.out.println("당첨 번호를 입력해 주세요.");
            try {
                prize = new Lotto(sc.nextLine());
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();
        return prize;
    }

    public int inputBonusInt(Lotto lt) {
        List<Integer> winningNumbers = lt.getNumbers();
        boolean isValid = false;
        int bonus;
        while (!isValid) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                String input = sc.nextLine();
                bonus = validationService.bonusNumberValidate(input, winningNumbers);
                isValid = true;
                System.out.println();
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                sc.nextLine();
            }
        }
        return 0;
    }
}
