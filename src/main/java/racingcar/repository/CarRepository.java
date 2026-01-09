package racingcar.repository;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {
    private final List<Car> cars;

    public CarRepository() {
        cars = new ArrayList<>();
    }

    public List<Car> findAll() {
        return cars;
    }

    public void addCar(Car car) {
        cars.add(car);
    }

    public Car findCarByCarName(String carName) {
        return cars.stream()
                .filter(car -> car.getName().equals(carName))
                .findFirst().orElse(null);
    }

    public List<Car> findCarsByPos(int pos) {
        return cars.stream()
                .filter(car -> car.getPos() == pos)
                .toList();
    }
}
