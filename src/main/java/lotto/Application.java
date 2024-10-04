package lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Application {
    static final Scanner sc = new Scanner(System.in);
    static final Validation vd = new Validation(1000);
    static final ResultPrint resultPrint = new ResultPrint();
    public static void main(String[] args) {
        //로또 구매 금액 입력 받은 후 객체 생성
        int count=vd.purchase();
        System.out.printf("%d개를 구매했습니다.\n",count);
        List<Lotto> lottoList = Stream.generate(Lotto::new).limit(count)
                .collect(Collectors.toCollection(ArrayList::new));
        //당첨 번호 입력받아 당첨 로또 만들기
        Lotto prizeLotto = new Lotto(vd.prize());
        //보너스 번호 입력받아 저장
        int bonus = vd.Bonus(prizeLotto);
        //당첨 확인
        prizeLotto.Match(lottoList,bonus);
        resultPrint.Print(count);
    }
}
