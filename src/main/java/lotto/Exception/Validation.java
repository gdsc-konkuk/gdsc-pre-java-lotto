package lotto.Exception;

import lotto.Model.Lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Validation Class
 * 1. Input의 검증 관리
 * 2. Lotto 객체 생성시 검증 관리
 * */
public class Validation {
    private static final int AMOUNT_UNIT = 1000;

    public static void inputAmount(int input){
        if (input < AMOUNT_UNIT || input % AMOUNT_UNIT != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력해주세요.");
        }
    }

    public static void lottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        for(Integer integer: numbers){
            Validation.lottoNumberRange(integer);
        }
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("올바른 숫자 6개를 입력해주세요.");
        }
        Set<Integer> set = new HashSet<>(numbers);
        if (numbers.size() != set.size()) {
            throw new IllegalArgumentException("올바른 숫자 6개를 입력해주세요.");
        }
    }

    public static void lottoNumberRange(Integer integer) {
        if (integer < 1 || integer > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 정수를 입력해주세요.");
        }
    }

    public static void bonusNumber(Lotto lotto, Integer integer) {
        if (lotto.getNumbers().contains(integer)) {
            throw new IllegalArgumentException("[ERROR] 보너스 숫자는 당첨 번호에 없는 숫자여야합니다.");
        }
    }

}
