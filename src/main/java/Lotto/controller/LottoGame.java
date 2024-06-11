package Lotto.controller;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;
import Lotto.model.InputView;
import Lotto.model.OutputView;
import Lotto.service.LottoCalculateService;
import Lotto.service.LottoService;
import Lotto.service.LottoWinningService;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Map;

public class LottoGame {

    private static final LottoService lottoService = new LottoService();

    
    public static void start(){

        int inputMoney = receiveInputMoney();
        int manualLottoCount = receiveInputManualCount();

        OutputView.printManualLottoNumber();
        List<Lotto> manualLotto = new ArrayList<>();
        for(int i=0; i < manualLottoCount; i++){
            manualLotto.add(receiveInputManualLotto());
        }
        MyLotto myLotto = new MyLotto(manualLotto);
        List<Lotto> autoLotto = lottoService.generateMyLotto(inputMoney, manualLottoCount);
        myLotto.combineLotto(autoLotto);
        OutputView.printMyLotto(myLotto, manualLottoCount);

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
                return InputView.requestInputLotto();
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

    private static int receiveInputManualCount(){
        while(true){
            try{
                OutputView.printManualLotto();
                return InputView.requestInputManualCount();
            }catch(InputMismatchException e){
                OutputView.printErrorMessage(e);
            }
        }
    }

    private static Lotto receiveInputManualLotto(){
        while(true){
            try{
                return InputView.requestInputLotto();
            }catch(InputMismatchException e){
                OutputView.printErrorMessage(e);
            }
        }
    }

}
