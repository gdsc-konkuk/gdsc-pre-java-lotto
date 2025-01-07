package lotto;

import lotto.Product.Lotto;

import java.util.List;
import java.util.Scanner;

public class IOSequence {
    private Scanner sc;
    public IOSequence(Scanner sc) {
        this.sc = sc;
    }
    public int inputInt() {
        int input = 0;
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String s = sc.nextLine();
                input = Integer.parseInt(s);
                if (input <= 0) {
                    System.out.println("[ERROR]구입금액은 1 이상의 숫자를 입력해야 합니다.");
                    continue;
                } else if (input%1000!=0){
                    System.out.println("[ERROR]구입금액은 1000으로 나눠져야 합니다.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.out.println("[ERROR]잘못된 입력입니다. 숫자를 입력해 주세요.");
            }
        }
        return input;
    }
    public Lotto inputWinningLotto(){
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
    public int inputBonusInt(Lotto lt){
        List<Integer> winningNumbers = lt.getNumbers();
        boolean isValid = false;
        int bonus;
        while (!isValid) {
            System.out.println("보너스 번호를 입력해 주세요.");
            try{
                String input = sc.nextLine();
                bonus = Integer.parseInt(input);
                if(winningNumbers.contains(bonus)){
                    throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
                }else if(bonus<1 || bonus>45){
                    throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
                }
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
    public void outputLottoList(List<Lotto> lottoList){
        System.out.println(lottoList.size()+"개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.getNumbers());
        }
        System.out.println();
    }
    public void outputGrade(List<Integer> gradeList){
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", gradeList.get(0));
        System.out.printf("4개 일치 (50,000원) - %d개\n", gradeList.get(1));
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", gradeList.get(2));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", gradeList.get(3));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", gradeList.get(4));
    }
    public void outputRateOfProfit(double profit) {
        System.out.printf("총 수익률은 %.1f%%%s", profit, "입니다.");
    }
}
