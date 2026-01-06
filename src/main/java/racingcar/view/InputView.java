package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.InputParser;

import java.util.List;
import java.util.function.Supplier;

public class InputView {
    private final InputParser inputParser;

    public InputView(InputParser inputParser) {
        this.inputParser = inputParser;
    }

    // 차 이름 입력받기
    public List<String> inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        return inputParser.parse(input);
    }

    // 시도할 회수는 몇회인가요?
    public int inputTurns() {
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();

        if(input.matches("![0-9]+")){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 반드시 숫자여야 합니다.");
        }

        int turn = Integer.parseInt(input);
        if(turn <= 0){
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 반드시 0보다 커야 합니다.");
        }

        return turn;
    }
//
//    private <T> T retryOnError(Supplier<T> supplier) {
//        while (true) {
//            try {
//                return supplier.get();
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
}
