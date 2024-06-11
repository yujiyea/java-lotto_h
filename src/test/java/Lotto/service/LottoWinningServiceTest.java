package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoWinningServiceTest {

    @DisplayName("로또의 당첨 개수 확인")
    @ParameterizedTest
    @MethodSource("generateData")
    void lotto_match(Lotto lotto, int count){
        //given
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, 45);

        //when
        int matchCount = lottoWinningService.compareLotto(lotto);

        //then
        assertThat(matchCount).isEqualTo(count);
    }

    @DisplayName("보너스의 당첨 여부 확인 - 성공")
    @Test
    void lotto_match(){
        //given
        int bonus = 7;
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));
        Lotto lotto = new Lotto(List.of(1,3,6,15,32,bonus));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, bonus);

        //when
        boolean matchBonus = lottoWinningService.compareLottoBonus(lotto);

        //then
        assertThat(matchBonus).isTrue();
    }

    @DisplayName("보너스의 당첨 여부 확인 - 실패")
    @Test
    void lotto_not_match(){
        //given
        int bonus = 7;
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));
        Lotto lotto = new Lotto(List.of(1,3,6,15,32,8));

        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, bonus);

        //when
        boolean matchBonus = lottoWinningService.compareLottoBonus(lotto);

        //then
        assertThat(matchBonus).isFalse();
    }

    @DisplayName("로또 개수만큼 확인")
    @Test
    void check_myLotto(){
        //given
        Lotto resultLotto = new Lotto(List.of(1,3,6,15,32,42));
        LottoWinningService lottoWinningService = new LottoWinningService(resultLotto, 45);
        List<Lotto> lottoList = List.of(new Lotto(List.of(1,3,6,9,23,17)),
                new Lotto(List.of(1,3,6,15,23,17)),
                new Lotto(List.of(1,3,6,15,32,17)),
                new Lotto(List.of(1,3,6,15,32,42)),
                new Lotto(List.of(1,3,6,15,32,45)),
                                        new Lotto(List.of(2,4,7,10,13,18)),
                                        new Lotto(List.of(2,4,7,10,13,27)));
        MyLotto myLotto = new MyLotto(lottoList);

        Map<MatchPrice, Integer> resultMap = new EnumMap<>(MatchPrice.class);
        resultMap.put(MatchPrice.THREE_MATCH, 1);
        resultMap.put(MatchPrice.FOUR_MATCH, 1);
        resultMap.put(MatchPrice.FIVE_MATCH, 1);
        resultMap.put(MatchPrice.FIVE_BONUS_MATCH, 1);
        resultMap.put(MatchPrice.SIX_MATCH, 1);

        //when
        lottoWinningService.checkMyLottoWinning(myLotto);

        //then
        assertThat(myLotto.getWinningResult()).isEqualTo(resultMap);
    }

    static Stream<Arguments> generateData(){
        return Stream.of(
                Arguments.of(new Lotto(List.of(1,3,6,9,23,17)), 3),
                Arguments.of(new Lotto(List.of(1,3,6,15,23,17)), 4),
                Arguments.of(new Lotto(List.of(1,3,6,15,32,17)), 5)
        );
    }
}