package Lotto.model;

import Lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class InputViewTest {

    @Test
    @DisplayName("타입 확인 - 보너스볼 범위 초과")
    void check_type_range(){
        //given
        int bonus_test = 46 ;

        InputView inputView = new InputView();

        //when & then
        assertThatIllegalArgumentException().isThrownBy(()->
                inputView.validateRange(bonus_test) );
    }

    @Test
    @DisplayName("타입 확인 - 당첨 번호")
    void check_type_inputLottoNumber(){
        //given
        String winningLotto = "1, 3, 5, 7a, 10, 11";

        InputView inputView = new InputView();

        //when & then
        assertThatIllegalArgumentException().isThrownBy(()->
                inputView.validateWinningLottoType(winningLotto) );
    }

}