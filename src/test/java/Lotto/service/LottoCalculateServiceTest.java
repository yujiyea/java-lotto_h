package Lotto.service;

import Lotto.domain.MatchPrice;
import org.junit.jupiter.api.Test;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LottoCalculateServiceTest {
    @Test
    void calculator_rate_of_return(){
        //given
        int money = 14000;
        Map<MatchPrice, Integer> map = new EnumMap<>(MatchPrice.class);
        map.put(MatchPrice.THREE_MATCH, 1);
        map.put(MatchPrice.FOUR_MATCH, 0);
        map.put(MatchPrice.FIVE_MATCH, 0);
        map.put(MatchPrice.FIVE_BONUS_MATCH, 0);
        map.put(MatchPrice.SIX_MATCH, 0);

        //when
        LottoCalculateService lottoCalculateService = new LottoCalculateService();
        double rate = lottoCalculateService.calculateTotalRate(map, money);

        //then
        assertThat(rate).isEqualTo(0.35);
    }

//    @Test
//    void test(){
//        final LottoNumber number1 = new LottoNumber.from(1);
//        final LottoNumber number2 = new LottoNumber.from(1);
//        assertThat(number1).isEqualTo(number2);
//        assertThat(number1).isSameAs(number2);
//    }
}