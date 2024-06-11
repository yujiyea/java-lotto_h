package Lotto.domain;

import java.util.Arrays;

public enum MatchPrice {

    THREE_MATCH(3, 5000, "3개 일치 (5000원)"),
    FOUR_MATCH(4, 50000, "4개 일치 (50000원)"),
    FIVE_MATCH(5, 1500000, "5개 일치 (1500000원)"),
    FIVE_BONUS_MATCH(51,30000000, "5개 일치, 보너스 볼 일치 (30000000원)"),
    SIX_MATCH(6, 2000000000, "6개 일치 (2000000000원)");

    private final int matchCount;
    private final int price;
    private final String message;

    MatchPrice(int matchCount, int price, String message) {
        this.matchCount = matchCount;
        this.price = price;
        this.message = message;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getPrice() {
        return price;
    }

    public String getMessage() {
        return message;
    }

    public static MatchPrice getMatchPrice(int matchCount){
        return Arrays.stream(values())
                .filter(value -> value.matchCount == matchCount)
                .findAny()
                .orElse(null);
    }

}
