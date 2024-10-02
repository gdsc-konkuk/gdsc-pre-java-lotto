package lotto;

import java.util.ArrayList;
import java.util.List;

public class Validation {
    public int purchase(String s) {
        if (s.matches("\\d+")) {
            int purchase = Integer.parseInt(s);
            if (purchase < 0 || purchase % 1000 != 0) {
                throw new IllegalArgumentException("[ERROR] 1000으로 나누어 떨어지는 자연수를 입력해야 합니다.");
            }
            return purchase;
        }
        throw new IllegalArgumentException("[ERROR] 자연수만 입력해야 합니다.");
    }
    public List<Integer> prize(String s){
        ArrayList<Integer> list = new ArrayList();
        String[] st=s.split(",");
        if (st.length != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 자연수를 기호 {,}를 활용하여 구분해 입력해야 합니다.");
        }
        for (String t : st) {
            int num = Integer.parseInt(t.trim());
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
    public int Bonus(String s, Lotto prizeNum) {
        if (s.matches("\\d+")) {
            int bonus = Integer.parseInt(s);
            if(bonus<1||bonus>45){
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            }else if(prizeNum.getNumbers().contains(bonus)){
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
            }
            return bonus;
        }
        throw new IllegalArgumentException("[ERROR] 자연수만 입력해야 합니다.");
    }
}
