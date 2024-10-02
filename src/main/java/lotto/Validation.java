package lotto;

import java.util.List;

public class Validation {
    public int purchase(String s) {
        if (s.matches("\\d+")) {
            int purchase = Integer.parseInt(s);
            if (purchase < 0 || purchase % 1000 != 0) {
                System.out.println("[ERROR] 1000으로 나누어 떨어지는 자연수를 입력해야 합니다.");
                throw new IllegalArgumentException();
            }
            return purchase;
        }
        System.out.println("[ERROR] 자연수만 입력해야 합니다.");
        throw new IllegalArgumentException();
    }
    public void prize(String s, List<Integer> prizeNum){
        String[] st=s.split(",");
        if (st.length != 6) {
            System.out.println("[ERROR] 6개의 자연수를 기호 {,}를 활용하여 구분해 입력해야 합니다.");
            throw new IllegalArgumentException();
        }
        for (String t : st) {
            int num = Integer.parseInt(t.trim());
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
    public int Bonus(String s, List<Integer> prizeNum) {
        if (s.matches("\\d+")) {
            int bonus = Integer.parseInt(s);
            if(bonus<1||bonus>45){
                System.out.println("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
                throw new IllegalArgumentException();
            }else if(prizeNum.contains(bonus)){
                System.out.println("[ERROR] 중복되지 않는 값을 정해야 합니다.");
                throw new IllegalArgumentException();
            }
            return bonus;
        }
        System.out.println("[ERROR] 자연수만 입력해야 합니다.");
        throw new IllegalArgumentException();
    }
}
