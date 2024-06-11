package Lotto.model;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;

import java.util.List;
import java.util.Map;

public class OutputView {
    public static void printInputMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void printInputWinningLotto(){
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static void printInputBonus(){
        System.out.println("보너스 볼을 입력해 주세요.");
    }

    public static void printMyLotto(MyLotto myLotto, int manualCount){
        List<Lotto> lottoList = myLotto.getLottoList();
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.\n",manualCount, lottoList.size()-manualCount);
        for(Lotto lotto: lottoList){
             printLottoNumber(lotto.getLottoNumber());
        }
    }

    public static void printLottoNumber(List<Integer> lottoNumber){
        System.out.print("[");

        for(int i=0; i<lottoNumber.size()-1; i++){
            System.out.printf("%d, ", lottoNumber.get(i));
        }
        System.out.print(lottoNumber.get(lottoNumber.size()-1));
        System.out.println("]");
    }

    public static void printWinningResult(Map<MatchPrice, Integer> winningResult){
        System.out.println("당첨 통계");
        System.out.println("-------------");
        for(MatchPrice matchPrice : MatchPrice.values()){
            System.out.println(matchPrice.getMessage()+"- " + winningResult.getOrDefault(matchPrice,0)+"개");
        }
    }

    public static void printWinningToTal(double winningTotal){
        System.out.println("총 수익률을 " + winningTotal + "입니다.");
    }

    public static void printErrorMessage(Exception e){
        System.out.println("[ERROR] " + e.getMessage());
    }

    public static void printManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
    }

    public static void printManualLottoNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }
}
