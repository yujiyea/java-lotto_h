package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.MyLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {
    private final LottoService lottoService = new LottoService();

    @Test
    @DisplayName("로또 발급")
    void generate_lotto_number(){
        //given & when
        Lotto lotto = lottoService.generateLottoNumbers();

        //then
        assertThat(lotto.getLottoNumber().size()).isEqualTo(6);
        assertThat(lotto.getLottoNumber()).doesNotHaveDuplicates();
    }

//    @Test
//    @DisplayName("입력받은 금액에 해당하는 로또 발급")
//    void generate_my_lotto(){
//        //given
//        int money = 14000;
//        int lottoCount = money/1000;
//
//        //when
//        MyLotto myLotto = lottoService.generateMyLotto(money);
//
//        //then
//        assertThat(myLotto.getLottoList().size()).isEqualTo(lottoCount);
//    }

    @Test
    @DisplayName("수동 로또 제외 자동 로또 발급")
    void generate_auto_lottoList(){
        //given
        int money = 14000;
        List<Lotto> manualLotto = new ArrayList<>();
        manualLotto.add(new Lotto(List.of(35, 36, 42, 38, 7, 17)));
        manualLotto.add(new Lotto(List.of(14, 40, 38, 1, 25, 34)));
        manualLotto.add(new Lotto(List.of(40, 38, 22, 42, 24, 17)));

        MyLotto myLotto = new MyLotto(manualLotto);
        int manualLottoCount = myLotto.getLottoList().size();

        //when
        List<Lotto> autoLotto = lottoService.generateMyLotto(money, manualLottoCount);
        myLotto.combineLotto(autoLotto);

        //then
        assertThat(myLotto.getLottoList()).hasSize(14);
    }

}