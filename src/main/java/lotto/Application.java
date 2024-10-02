package lotto;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        //입력받기
        InputSequence is =new InputSequence(new Scanner(System.in),new Validation());
        is.PurchaseSequence();
        is.PrizeSequence();
        is.BonusSequence();
        //계산하기
        MatchSequence ms=new MatchSequence(is.getPrizeNum(),is.getBonus(),is.getBuy());
        ms.Matching();
        //출력하기
        PrintSequence ps=new PrintSequence(ms.getResult(),ms.getBuy());
        ps.Calculate();
        ps.ResultPrint();
    }
}
