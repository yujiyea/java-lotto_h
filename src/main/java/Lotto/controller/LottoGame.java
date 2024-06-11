package Lotto.controller;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;
import Lotto.model.InputView;
import Lotto.model.OutputView;
import Lotto.service.LottoCalculateService;
import Lotto.service.LottoService;
import Lotto.service.LottoWinningService;

import java.util.InputMismatchException;
import java.util.Map;

public class LottoGame {

    private static final LottoService lottoService = new LottoService();

    
    public static void start(){

        int inputMoney = receiveInputMoney();

        MyLotto myLotto = lottoService.generateMyLotto(inputMoney);
        OutputView.printMyLotto(myLotto);

        Lotto winningLotto = receiveWinningLotto();

        int bonusNumber = receiveBonusNumber();

        LottoWinningService lottoWinningService = new LottoWinningService(winningLotto, bonusNumber);
        lottoWinningService.checkMyLottoWinning(myLotto);

        Map<MatchPrice, Integer> winningResult = myLotto.getWinningResult();
        OutputView.printWinningResult(winningResult);

        double winningTotalRate = LottoCalculateService.calculateTotalRate(winningResult, inputMoney);
        OutputView.printWinningToTal(winningTotalRate);
    }

    private static int receiveBonusNumber() {
        while(true){
            try{
                OutputView.printInputBonus();
                return InputView.requestInputBonus();
            }catch(InputMismatchException e){
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static Lotto receiveWinningLotto() {
        while(true){
            try{
                OutputView.printInputWinningLotto();
                return InputView.requestInputWinningLotto();
            }catch(InputMismatchException e){
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static int receiveInputMoney() {
        while(true){
            try{
                OutputView.printInputMoney();
                return InputView.requestInputMoney();
            }catch(InputMismatchException e){
                OutputView.printErrorMessage(e);
            }
        }
    }

}
