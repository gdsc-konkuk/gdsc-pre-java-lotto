package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class InputSequence {
    private Scanner sc;
    private List<Integer> prizeNum;
    private int purchase;
    private int bonus;
    private List<Lotto> buy;
    private Validation vd;

    public InputSequence(Scanner scanner, Validation vd) {
        this.vd=vd;
        this.sc = scanner;
    }

    public void PurchaseSequence() {
        try {
            Purchase();
        } catch (IllegalArgumentException e) {
            PurchaseSequence();
        }
        buy = new ArrayList<>();
        System.out.println("\n" + purchase / 1000 + "개를 구매했습니다.");
        for (int i = 0; i < purchase / 1000; i++) {
            Lotto l = new Lotto();
            buy.add(l);
            l.printField();
        }
    }

    private void Purchase() {
        System.out.println("구입 금액을 입력해 주세요.");
        String input=sc.nextLine();
        purchase=vd.purchase(input);
    }

    public void PrizeSequence() {
        prizeNum = new ArrayList<>();
        try {
            Prize();
        } catch (IllegalArgumentException e) {
            PrizeSequence();
        }
    }

    private void Prize() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        vd.prize(sc.nextLine(),prizeNum);
    }

    public void BonusSequence() {
        try {
            Bonus();
        }catch (IllegalArgumentException e){
            BonusSequence();
        }
    }

    private void Bonus() {
        System.out.println("\n"+"보너스 번호를 입력해 주세요.");
        bonus=vd.Bonus(sc.nextLine(),prizeNum);
    }

    public List<Integer> getPrizeNum() {
        return prizeNum;
    }

    public List<Lotto> getBuy() {
        return buy;
    }

    public int getBonus() {
        return bonus;
    }

}
