package Lotto.model;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public void printInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printInputWinningLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public void printInputBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public void printMyLotto(MyLotto myLotto){
        List<Lotto> lottoList = myLotto.getLottoList();
        System.out.printf("%d개를 구매했습니다.\n",lottoList.size());
        for(Lotto lotto: lottoList){
             printLottoNumber(lotto.getLottoNumber());
        }

    }

    public void printLottoNumber(List<Integer> lottoNumber){
        System.out.print("[");

        for(int i=0; i<lottoNumber.size()-1; i++){
            System.out.printf("%d, ", lottoNumber.get(i));
        }
        System.out.print(lottoNumber.get(lottoNumber.size()-1));
        System.out.println("]");
    }

    public void printWinningResult(Map<MatchPrice, Integer> winningResult){
        System.out.println("당첨 통계");
        System.out.println("-------------");

    }
}
