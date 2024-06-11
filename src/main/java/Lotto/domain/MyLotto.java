package Lotto.domain;

import java.util.List;
import java.util.Map;

public class MyLotto {
    private static final int LOTTO_PRICE = 1000;
    private List<Lotto> lottoList;

    private Map<MatchPrice, Integer> winningResult;

    public MyLotto(List<Lotto> lottoList, Map<MatchPrice, Integer> winningResult) {
        this.lottoList = lottoList;
        this.winningResult = winningResult;
    }

    public MyLotto(List<Lotto> lottoList) {
        this.lottoList = lottoList;
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Map<MatchPrice, Integer> getWinningResult() {
        return winningResult;
    }

    public void setWinningResult(Map<MatchPrice, Integer> map){
        winningResult = map;
    }


    public void combineLotto(List<Lotto> autoLotto) {
//        lottoList.addAll(autoLotto);
        for (Lotto lotto : autoLotto){
            lottoList.add(lotto);
        }
    }
}
