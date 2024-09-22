package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        InputSequence is =new InputSequence(new Scanner(System.in));
        is.start();
        MatchSequence ms=new MatchSequence(is.getPrizeNum(),is.getBonus(),is.getBuy());
        ms.start();
    }
}
