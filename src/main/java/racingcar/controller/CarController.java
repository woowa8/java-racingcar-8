package racingcar.controller;

import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.service.CarService;
import racingcar.util.InputParser;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class CarController {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarService carService;

    public CarController() {
        InputParser inputParser = new InputParser();
        this.inputView = new InputView(inputParser);

        this.outputView = new OutputView();

        CarRepository carRepository = new CarRepository();
        this.carService = new CarService(carRepository);
    }

    // 실행을 관리하는 run
    public void run() {
        List<String> carsName = inputView.inputCarName();
        int roop = inputView.inputTurns();

        List<Car> cars;

        try{
            cars = saveCars(carsName);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            throw e;  // assertThatThrownBy() 이므로, 다시 던지기
        }

        outputView.printTitle();
        for(int i = 0; i < roop; i++) {
            drive(cars);
            outputView.printCarRacing(cars);
        }

        outputView.printWinners(carService.findWinner());
    }

    private void drive(List<Car> cars) {
        for(Car car : cars) {
            carService.move(car);
        }
    }

    private List<Car> saveCars(List<String> carsName) {
        for (String carName : carsName) {
            carService.save(carName);
        }

        return carService.getCars();
    }
}
