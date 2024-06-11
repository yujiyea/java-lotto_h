package Lotto.service;

import Lotto.domain.Lotto;
import Lotto.domain.MatchPrice;
import Lotto.domain.MyLotto;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoWinningService {
    private final Lotto winLotto;
    private final int bonusNumber;


    public LottoWinningService(Lotto winLotto, int bonusNumber) {
        this.winLotto = winLotto;
        this.bonusNumber = bonusNumber;
    }

    public int compareLotto(Lotto lotto) {
        int count = 0;
        List<Integer> currentLotto = lotto.getLottoNumber();
        for (Integer integer : currentLotto) {
            if (winLotto.getLottoNumber().contains(integer)) {
                count++;
            }
        }
        if (count == 5 && compareLottoBonus(lotto)) {
            count = 51;
        }
        return count;
    }

    public boolean compareLottoBonus(Lotto lotto) {
        return lotto.getLottoNumber().contains(bonusNumber);
    }

    public void checkMyLottoWinning(MyLotto myLotto) {
        List<Lotto> lottoList = myLotto.getLottoList();
        Map<MatchPrice, Integer> map = new EnumMap<>(MatchPrice.class);

        for(Lotto lotto : lottoList){
            int result = compareLotto(lotto);
            if(result<3) continue;
            MatchPrice matchPrice = MatchPrice.getMatchPrice(result);
            map.put(matchPrice, map.getOrDefault(matchPrice, 0)+1);
        }


        myLotto.setWinningResult(map);
    }
}
