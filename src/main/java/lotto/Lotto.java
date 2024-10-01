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

    public Lotto(String userInputForWinnings) throws NumberFormatException {
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
        this.numbers = numberSet.stream().sorted().toList();
    }

    public static void validateLottoNumber(Integer integer){
        if(integer < 1 || integer > 45){
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 정수를 입력해주세요.");
        }
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
