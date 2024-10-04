package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.Exception.Exception;
import lotto.Model.Lotto;

import java.util.Arrays;
import java.util.List;

public class In {
    public Integer getAmount() throws NumberFormatException {
        System.out.println();
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String getWinLotto() {
        System.out.println();
        System.out.println("당첨 번호를 입력해주세요.");
        return Console.readLine();
    }

    public Integer getBonus(/*Lotto winLotto*/) throws NumberFormatException{
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
