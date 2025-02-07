package lotto.service;

import java.util.List;

public class ValidationService {
    public int purchaseMoneyValidate(String s){
        int input;
        try{
            input = Integer.parseInt(s);
        }catch (Exception e){
            throw new IllegalArgumentException();
        }
        if (input <= 0) {
            System.out.println("[ERROR]구입금액은 1 이상의 숫자를 입력해야 합니다. 프로그램을 종료합니다.");
            throw new IllegalArgumentException();
        } else if (input % 1000 != 0) {
            System.out.println("[ERROR]구입금액은 1000으로 나눠져야 합니다. 프로그램을 종료합니다.");
            throw new IllegalArgumentException();
        }
        return input;
    }
    public int bonusNumberValidate(String s, List<Integer> winningNumbers){
        int bonusNumber;
        try{
            bonusNumber = Integer.parseInt(s);
        }catch (Exception e){
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
        }
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 중복되지 않는 값을 정해야 합니다.");
        } else if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1~45 사이의 자연수를 입력해야 합니다.");
        }
        return bonusNumber;
    }
}
