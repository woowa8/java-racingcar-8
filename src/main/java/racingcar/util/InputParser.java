package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class InputParser {
    // , 으로 나누는 기능
    public List<String> parse(String input) {
        String[] cars = input.split(",");

        if (cars.length <= 1) {
            throw new IllegalArgumentException("[ERROR] 경주하는 자동차는 한 대 이상이어야 합니다.");
        }

        return Arrays.stream(cars).toList();
    }
}
