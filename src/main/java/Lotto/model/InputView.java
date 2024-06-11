package Lotto.model;

import Lotto.domain.Lotto;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {


    public static int requestInputMoney() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static Lotto requestInputWinningLotto() {
        Scanner scanner = new Scanner(System.in);
        String winningLotto = scanner.nextLine();
        validateWinningLottoType(winningLotto);
        return checkLottoNumber(winningLotto);
    }

    private static Lotto checkLottoNumber(String winningLotto) {
        List<String> list = Arrays.asList(winningLotto.split(", "));
        for(String number : list){
            validateRange(Integer.parseInt(number));
        }
        return new Lotto(list.stream().map(Integer::valueOf).collect(Collectors.toList()));
    }


    public static int requestInputBonus() {
        Scanner scanner = new Scanner(System.in);
        int inputBonus = scanner.nextInt();
        validateRange(inputBonus);

        return inputBonus;
    }

    public static void validateRange(int bonusNum) {
        if (bonusNum < 0 || bonusNum > 45 ){
            throw new IllegalArgumentException("숫자 범위 초과");
        }
    }

    public static void validateWinningLottoType(String winningLotto) {
        String pattern = "^\\d+, \\d+, \\d+, \\d+, \\d+, \\d+$";
        if (!Pattern.matches(pattern, winningLotto)){
            throw new IllegalArgumentException("당첨 로또 타입 불일치");
        }
    }
}
