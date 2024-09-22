package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto(){
        numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public void printField(){
        System.out.println(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
