package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    private OutputView() {
    }

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotto(List<Lotto> lottos) {
        for(Lotto lotto : lottos) {
            System.out.println("[" + lotto + "]");
        }
    }

    public static void printResult() {
        System.out.println("당첨 통계");
    }
}
