package racingcar.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/*
상태를 변경하는 메서드는 반드시 테스트

1. 전체 method 기능 테스트
2. null이 나올 경우 테스트 (이름이 없을 경우)
3. findCarsByPos의 경우, 같은 위치이면 여러 사람이 나오는지 test
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarRepositoryTest {

    private CarRepository carRepository;

    @BeforeEach
    public void setUp() {
        carRepository = new CarRepository();

        carRepository.addCar(new Car("영희"));
        carRepository.addCar(new Car("철수"));
        carRepository.addCar(new Car("사랑"));
        carRepository.addCar(new Car("희동"));
    }

    @Test
    void findAll로_모든_차를_찾을_수_있다() {
        //given

        //when
        List<Car> cars = carRepository.findAll();

        //then
        Assertions.assertThat(cars.size()).isEqualTo(4);
    }

    @Test
    void 차_이름으로_해당하는_차를_찾을_수_있다() {
        //given
        String name = "희동";

        //when
        Car car = carRepository.findCarByCarName(name);

        //then
        Assertions.assertThat(car.getName()).isEqualTo(name);
    }

    @Test
    void 해당하는_차가_없을_경우_null() {
        //given
        String name = "선정";

        //when
        Car car = carRepository.findCarByCarName(name);

        //then
        Assertions.assertThat(car).isNull();
    }

    @Test
    void 같은_위치의_차들을_찾을_수_있다() {
        //given
        Car car1 = carRepository.findCarByCarName("사랑");
        Car car2 = carRepository.findCarByCarName("철수");

        //when
        car1.addPos(1);
        car2.addPos(1);

        List<Car> cars = carRepository.findCarsByPos(1);

        //then
        Assertions.assertThat(cars.size()).isEqualTo(2);
        Assertions.assertThat(cars).extracting(Car::getName)
                .containsExactlyInAnyOrder("사랑", "철수"); // contains보다 더 정확하게 이들만 있는지 보고 싶을때는 이렇게 써준다.
    }
}