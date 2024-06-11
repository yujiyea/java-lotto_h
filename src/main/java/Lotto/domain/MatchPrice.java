package Lotto.domain;

import java.util.Arrays;

public enum MatchPrice {

    THREE_MATCH(3, 5000),
    FOUR_MATCH(4, 50000),
    FIVE_MATCH(5, 1500000),
    FIVE_BONUS_MATCH(51,30000000),
    SIX_MATCH(6, 2000000000);

    int matchCount;
    int price;

    MatchPrice(int matchCount, int price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public static MatchPrice getMatchPrice(int matchCount){
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(null);
    }

}
