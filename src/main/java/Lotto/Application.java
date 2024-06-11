package Lotto;

import Lotto.domain.Lotto;
import Lotto.domain.MyLotto;
import Lotto.model.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        List<Lotto> lottoList = List.of(new Lotto(List.of(1,3,6,9,23,17)),
                new Lotto(List.of(1,3,6,15,23,17)),
                new Lotto(List.of(1,3,6,15,32,17)),
                new Lotto(List.of(1,3,6,15,32,42)),
                new Lotto(List.of(1,3,6,15,32,45)),
                new Lotto(List.of(2,4,7,10,13,18)),
                new Lotto(List.of(2,4,7,10,13,27)));
        MyLotto myLotto = new MyLotto(lottoList);
        outputView.printMyLotto(myLotto);
    }
}
