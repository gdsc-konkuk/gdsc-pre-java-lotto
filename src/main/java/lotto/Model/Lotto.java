package lotto.Model;

import lotto.Exception.Exception;

import java.util.List;

/*
 * Lotto Class
 * 로또(6개의 숫자를 갖는 복권)라는 개념을 추상화한 객체
 * 1. 다른 로또와 몇개가 겹치는지 개수를 반환하는 로직 구현
 * 2. bonus number가 numbers에 포함되는지 확인하는 로직 구현
 * */

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        Exception.lottoNumbers(numbers);
        this.numbers = numbers.stream().sorted().toList();
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
