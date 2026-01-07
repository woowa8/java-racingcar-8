package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

/*
상태를 변경하는 메서드는 반드시 테스트

1. 생성 테스트
2. 생성시 초기화 되는것 테스트
3. validate 테스트 (예외)
4. 위치가 변하는 것이므로 이거 >> 한 번 & 여러번 가는 것 test
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {
    @Test
    void 자동차_생성시_이름이_저장된다() {
        //given
        Car car = new Car("sunJ");

        //when

        //then
        assertSimpleTest(() -> {
            Assertions.assertThat(car.getName()).isEqualTo("sunJ");
        });
    }

    @Test
    void 자동차_생성시_초기_위치는_0이다() {
        //given
        Car car = new Car("sunJ");

        //when

        //then
        assertSimpleTest(() -> {
            Assertions.assertThat(car.getPos()).isEqualTo(0);
        });
    }

    @Test
    void 이름은_다섯글자_이하여야_한다() {
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() -> new Car("sunJSS"))
                .isInstanceOf(IllegalArgumentException.class)    // 예외가 나오는 조건을 안에 넣는다.
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 이름이_다섯글자이면_진행_가능하다() {
        //given
        Car car = new Car("sunJS");

        //when

        //then
        assertSimpleTest(() -> {
            Assertions.assertThat(car.getName()).isEqualTo("sunJS");
        });
    }

    @Test
    void 이름은_빈칸일_수_없다() {
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() -> new Car(""))
                .isInstanceOf(IllegalArgumentException.class)    // 예외가 나오는 조건을 안에 넣는다.
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 이동_테스트() {
        //given
        Car car = new Car("sunJ");

        //when
        car.addPos(1);

        //then
        assertSimpleTest(() -> {
            Assertions.assertThat(car.getPos()).isEqualTo(1);
        });
    }

    @Test
    void 여러번_이동_테스트() {
        //given
        Car car = new Car("sunJ");

        //when
        car.addPos(1);
        car.addPos(2);
        car.addPos(3);

        //then
        assertSimpleTest(() -> {
            Assertions.assertThat(car.getPos()).isEqualTo(6);
        });
    }
}