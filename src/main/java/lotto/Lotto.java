package lotto;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>(numbers);
        if(numbers.size() != set.size()){
            throw new IllegalArgumentException();
        }
    }

    public void validateBonus(Integer integer){
        if(numbers.contains(integer)){
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호에 없는 숫자여야합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        StringBuilder ret = new StringBuilder("[");
        for (int i = 0; i < this.numbers.size(); i++) {
            ret.append(this.numbers.get(i));
            if (i < this.numbers.size() - 1) {
                ret.append(", ");
            }
        }
        ret.append("]");
        return ret.toString();
    }

    public Long countDup(Lotto target){
        return this.numbers.stream().filter(target.getNumbers()::contains).count();
    }

    public boolean isBonus(Integer bonus){
        return this.numbers.contains(bonus);
    }
}
