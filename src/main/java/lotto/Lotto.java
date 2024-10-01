package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Lotto Class
 * 로또(6개의 숫자를 갖는 복권)라는 개념을 추상화한 객체
 * 1. 로또를 만들기 위해 검증이 필요하면, 그 로직을 static method 로 구현
 * 2. Lotto의 numbers를 통해 보너스 번호를 검증하는(사용가능한 bonus인지 확인하는) 로직 구현
 * 3. 다른 로또와 몇개가 겹치는지 개수를 반환하는 로직 구현
 * 4. bonus number가 numbers에 포함되는지 확인하는 로직 구현
 * */

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    public Lotto(String userInputForWinnings) throws IllegalArgumentException {
        List<Integer> numbers = Arrays.stream(userInputForWinnings.split(","))
                .map(s -> {
                    int number = Integer.parseInt(s.trim());
                    Lotto.validateLottoNumber(number);
                    return number;
                }).toList();
        validate(numbers);
        this.numbers = numbers.stream().sorted().toList();
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateLottoNumber(Integer integer) {
        if (integer < 1 || integer > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 정수를 입력해주세요.");
        }
    }

    public void validateBonus(Integer integer) {
        if (numbers.contains(integer)) {
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

    public Long countDup(Lotto target) {
        return this.numbers.stream().filter(target.getNumbers()::contains).count();
    }

    public boolean isBonus(Integer bonus) {
        return this.numbers.contains(bonus);
    }
}
