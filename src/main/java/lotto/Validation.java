package lotto;

import com.sun.tools.javac.Main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Validation {
    private Scanner sc= Application.sc;
    private final int lottoPrice;

    public Validation(int lottoPrice) {
        this.lottoPrice = lottoPrice;
    }

    public int purchase() {
        int validAmount = -1;
        boolean isValid = false;
        while (!isValid) {
            System.out.println("구입 금액을 입력해 주세요.");
            try {
                String input = sc.nextLine();
                validAmount = purchaseValid(input);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return validAmount/lottoPrice;
    }

    private int purchaseValid(String s) {
        if (s.matches("\\d+")) {
            int purchase = 0;
            try {
                purchase = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] -2^31부터 2^31-1까지의 범위 내에서 입력해야 합니다.");
            }
            if (purchase < 0 || purchase % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 자연수를 입력해야 합니다.");
            }
            return purchase;
        }
        throw new IllegalArgumentException("[ERROR] 자연수만 입력해야 합니다.");
    }

    public List<Integer> prize() {
        boolean isValid = false;
        List<Integer> prize = null;
        while (!isValid) {
            System.out.println("\n" + "당첨 번호를 입력해 주세요.");
            try {
                String input = sc.nextLine();
                prize = prizeValid(input);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return prize;
    }

    public List<Integer> prizeValid(String s) {
        ArrayList<Integer> list = new ArrayList();
        String[] st = s.split(",");
        if (st.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 자연수를 기호 {,}를 활용하여 구분해 입력해야 합니다.");
        }
        for (String t : st) {
            int num = 0;
            try {
                num = Integer.parseInt(t.trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            }
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            } else if (list.contains(num)) {
                list.clear();
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
            }
            list.add(num);
        }
        return list;
    }

    public int Bonus(Lotto prizeNum) {
        boolean isValid = false;
        int bonus = 0;
        while (!isValid) {
            System.out.println("\n" + "당첨 번호를 입력해 주세요.");
            try {
                String input = sc.nextLine();
                bonus = bonusValid(input, prizeNum);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return bonus;
    }

    private int bonusValid(String s, Lotto prizeNum) {
        if (s.matches("\\d+")) {
            int bonus = Integer.parseInt(s);
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            } else if (prizeNum.getNumbers().contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
            }
            return bonus;
        }
        throw new IllegalArgumentException("[ERROR] 자연수만 입력해야 합니다.");
    }

}
