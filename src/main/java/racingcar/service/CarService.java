package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;

import java.util.List;

public class CarService {
    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    // 우승자 판별 로직 (pos가 가장 큰 사람들)
    public List<Car> findWinner() {
        List<Car> cars = carRepository.findAll();
        int maxPos = findMaxPos(cars);

        return carRepository.findCarsByPos(maxPos);
    }

    // 가장 큰 위치 구하기
    private int findMaxPos(List<Car> cars) {
        int maxPos = 0;
        for (Car car : cars) {
            maxPos = Math.max(maxPos, car.getPos());
        }
        return maxPos;
    }

    // 운전 로직 (car 도메인 내부의 add)
    public void move(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4) {
            car.addPos(1);
        }
    }

    // 차 저장 로직
    public void save(String carName) {
        if (carRepository.findCarByCarName(carName) != null) {
            throw new IllegalStateException("[ERROR] 이미 있는 차 이름입니다.");
        }
        carRepository.addCar(new Car(carName));
    }

    public List<Car> getCars() {
        return carRepository.findAll();
    }
}
