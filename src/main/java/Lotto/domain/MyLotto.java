package Lotto.domain;

import java.util.List;
import java.util.Map;

public class MyLotto {
    private final List<Lotto> lottoList;

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
}
