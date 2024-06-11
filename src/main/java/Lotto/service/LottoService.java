package Lotto.service;

import Lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService { // 생성용 서비스
    private static final int LOTTO_PRICE = 1000;
    public Lotto generateLottoNumbers(){
        List<Integer> lottoNumberRange = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            lottoNumberRange.add(i);
        }

        Collections.shuffle(lottoNumberRange);
        List<Integer> lottoNumbers = lottoNumberRange.subList(0,6);

        return new Lotto(lottoNumbers);
    }


    public List<Lotto> generateMyLotto(int money, int  manualLottoCount) {
        int lottoTotalCount = money/LOTTO_PRICE;
        int restLottoCount = lottoTotalCount - manualLottoCount;
        List<Lotto> lottoList = new ArrayList<>();

        for(int i=0; i<restLottoCount; i++){
            lottoList.add(generateLottoNumbers());
        }

        return lottoList;
    }
}
