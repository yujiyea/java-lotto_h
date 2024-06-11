package Lotto.service;

import Lotto.domain.MatchPrice;

import java.util.Map;

public class LottoCalculateService {
    public static double calculateTotalRate(Map<MatchPrice, Integer> map, int money) {
        double totalPrice = 0f ;

        for(MatchPrice key : map.keySet()){
            totalPrice += key.getPrice() * map.get(key);
        }

        return (Math.floor((totalPrice/money)*100)/100.0);
    }
}
