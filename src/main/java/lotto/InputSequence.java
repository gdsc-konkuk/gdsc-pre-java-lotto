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

    public InputSequence(Scanner scanner) {
        this.sc = scanner;
        //readLine()의 존재를 너무 늦게알아챈 탓에, 스캐너쓰겠습니다. 봐주세요 봐주세요 봐주세요 >_<~~
    }
    public void start(){
        PurchaseSequence();
        PrizeSequence();
        BonusSequence();
    }

    private void PurchaseSequence() {
        try {
            Purchase();
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 1000으로 나누어 떨어지는 자연수를 입력해야 합니다.");
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
        purchase = sc.nextInt();
        sc.nextLine();
        if (purchase < 0 || purchase % 1000 != 0) {
            throw new IllegalArgumentException();
        }
    }

    private void PrizeSequence() {
        prizeNum = new ArrayList<>();
        try {
            Prize();
        } catch (IllegalArgumentException e) {
            PrizeSequence();
        }
    }

    private void Prize() {
        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String[] st = sc.nextLine().split(",");
        if (st.length != 6) {
            System.out.println("[ERROR] 6개의 자연수를 기호 {,}를 활용하여 구분해 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        for (String s : st) {
            int num = Integer.parseInt(s.trim());
            if (num < 1 || num > 45) {
                System.out.println("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
                throw new IllegalArgumentException();
            } else if (prizeNum.contains(num)) {
                System.out.println("[ERROR] 중복되지 않는 값을 정해야 합니다.");
                prizeNum.clear();
                throw new IllegalArgumentException();
            }
            prizeNum.add(num);
        }
    }

    private void BonusSequence() {
        try {
            Bonus();
        }catch (IllegalArgumentException e){
            BonusSequence();
        }
    }

    private void Bonus() {
        System.out.println("\n"+"보너스 번호를 입력해 주세요.");
        bonus=sc.nextInt();
        if(bonus<1||bonus>45){
            System.out.println("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            throw new IllegalArgumentException();
        }else if(prizeNum.contains(bonus)){
            System.out.println("[ERROR] 중복되지 않는 값을 정해야 합니다.");
            throw new IllegalArgumentException();
        }
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
