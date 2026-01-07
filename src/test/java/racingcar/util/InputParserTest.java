package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.List;

/*
1. ,으로 나눠져서 잘 들어가는지
2. 자동차가 한 대 이하일때 에러
 */
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class InputParserTest {
    private InputParser inputParser = new InputParser();

    @Test
    void 자동차는_쉼표로_나눠진다() {
        //given
        String input = "꼬링크,럭시오,렌트라";

        //when
        List<String> parsed = inputParser.parse(input);

        //then
        Assertions.assertThat(parsed)
                .containsExactlyInAnyOrder("꼬링크","럭시오","렌트라");
    }

    @Test
    void 자동차는_한_대_이상이어야_한다() {
        //given
        String input = "기라티나";

        //when

        //then
        Assertions.assertThatThrownBy(() -> inputParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class)    // 예외가 나오는 조건을 안에 넣는다.
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 쉼표만_있으면_예외발생() {
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() -> inputParser.parse(",,,"))
                .isInstanceOf(IllegalArgumentException.class)    // 예외가 나오는 조건을 안에 넣는다.
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 빈_문자열은_예외발생() {
        //given

        //when

        //then
        Assertions.assertThatThrownBy(() -> inputParser.parse(""))
                .isInstanceOf(IllegalArgumentException.class)    // 예외가 나오는 조건을 안에 넣는다.
                .hasMessageContaining("[ERROR]");
    }
}