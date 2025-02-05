package lotto.Product;

import java.util.ArrayList;
import java.util.List;

public class Lotto implements Product {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public Lotto(String s) {
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
        list.sort(Integer::compareTo);
        this.numbers = list;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 6개의 자연수를 기호 {,}를 활용하여 구분해 입력해야 합니다.");
        }
        ArrayList<Integer> list = new ArrayList();
        for (int num : numbers) {
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
            } else if (list.contains(num)) {
                list.clear();
                throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
            }
            list.add(num);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
    // Refactor : Lotto 에서 당첨 번호 체크하게끔 함
    public boolean matchNumber(int winNum){
        if (this.numbers.contains(winNum)) {
            return true;
        }return false;
    }

    // Refactor : Lotto 에서 스스로 보너스 번호 체크하게끔 함
    public int matchBonusNumber(int winningBonusNumber){
        return numbers.contains(winningBonusNumber) ? 1 : 0;
    }


}