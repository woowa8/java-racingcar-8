package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    // 실행 결과 제목
    public void printTitle() {
        System.out.println("실행 결과");
    }

    // 게임 실행 결과 자체를 계속 내보내는 기능
    public void printCarRacing(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println(printCarPos(car.getPos(), car.getMark()));
        }
        System.out.println();
    }

    private String printCarPos(int pos, String mark) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < pos; i++) {
            sb.append(mark);
        }
        return sb.toString();
    }

    // 최종 우승자 내보내는 기능
    public void printWinners(List<Car> cars) {
        System.out.println("최종 우승자 : " + mixtureWinners(cars));
        System.out.println();
    }

    private String mixtureWinners(List<Car> cars) {
        StringBuilder sb = new StringBuilder();
        for (Car car : cars) {
            sb.append(car.getName() + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());    // 끝에 더해진 , 지우기

        return sb.toString();
    }
}
