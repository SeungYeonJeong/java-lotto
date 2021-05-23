package lotto.domains;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {

    @Test
    void 로또_갯수_테스트() {
        Lottos lottos = new Lottos(Arrays.asList(new Lotto(),new Lotto()));
        assertThat(lottos.count()).isEqualTo(2);
    }
    
    @Test
    void 통계값_3개일치_가져오기_테스트() {
        LottoNumbers winningLottoNumbers = new LottoNumbers(Arrays.asList(1,2,3,4,5,6));
        Lotto lotto = new Lotto(new LottoNumbers(Arrays.asList(1,2,3,14,15,16)));
        Lottos lottos = new Lottos(Arrays.asList(lotto));
        assertThat(lottos.getStatistics(winningLottoNumbers).count(3)).isEqualTo(1);
    }
}