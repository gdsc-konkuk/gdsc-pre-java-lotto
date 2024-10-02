package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;
    Validation vd=new Validation();
    public Lotto(List<Integer> numbers) {
        String s = numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
        this.numbers=validate(s);
    }

    public Lotto(String s) {
        this.numbers=validate(s);
    }

    private List<Integer> validate(String s) {
        return vd.prize(s);
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
