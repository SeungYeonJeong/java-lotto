package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoCount;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoApplication {

    private static LottoCount lottoCount;
    private static LottoGenerator lottoGenerator = new LottoGenerator();
    private static WinningLotto winningLotto;
    private static LottoTicket lottoTicket;

    public static void main(String[] args) {
        setUp();
        List<Lotto> lottos = IntStream.range(0, lottoCount.count())
            .mapToObj((i) -> new Lotto(generateLottoNumber()))
            .collect(Collectors.toList());
        lottoTicket = new LottoTicket(lottos);
        OutputView.printLotto(lottoTicket.values());
        getWinningLotto();
        OutputView.printResult();

    }

    private static void getWinningLotto() {
        String winningLottoLine = InputView.getWinnerLotto();
        List<LottoNumber> lottoNumbers = Arrays.stream(winningLottoLine.split(", "))
            .mapToInt(Integer::parseInt)
            .mapToObj(LottoNumber::new)
            .collect(Collectors.toList());
        String bonusBall = InputView.getBonusBall();
        int parseBonus = Integer.parseInt(bonusBall);
        lottoNumbers.add(new LottoNumber(parseBonus));
        winningLotto = new WinningLotto(lottoNumbers);
    }

    private static void setUp() {
        String inputMoney = InputView.getMoneyToPurchase();
        Money money = new Money(inputMoney);
        lottoCount = new LottoCount(money.value());
        OutputView.printLottoCount(lottoCount.count());
    }

    private static List<LottoNumber> generateLottoNumber() {
        return lottoGenerator.generateLotto()
            .stream()
            .sorted()
            .map(LottoNumber::new)
            .collect(Collectors.toList());
    }
}
