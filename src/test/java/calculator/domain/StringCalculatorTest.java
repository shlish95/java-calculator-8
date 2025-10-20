package calculator.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class StringCalculatorTest {

    @Test
    void 빈문자열은_0을_반환한다() {
        assertEquals(0, StringCalculator.add(""));
        assertEquals(0, StringCalculator.add(null));
    }

    @Test
    void 기본구분자_콤마_콜론으로_합산한다() {
        assertEquals(3, StringCalculator.add("1,2"));
        assertEquals(6, StringCalculator.add("1,2,3"));
        assertEquals(6, StringCalculator.add("1,2:3"));
    }

    @Test
    void 커스텀_구분자_실제개행_지원한다() {
        assertEquals(6, StringCalculator.add("//;\n1;2;3"));
    }

    @Test
    void 커스텀_구분자_리터럴_역슬래시n_지원한다() {
        assertEquals(1, StringCalculator.add("//;\\n1"));
    }

    @Test
    void 커스텀_구분자_비어있으면_예외() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("//\n1,2,3"));
    }

    @Test
    void 숫자아님은_예외() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1,a"));
    }

    @Test
    void 빈토큰_혹은_공백토큰은_예외() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1,,2"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("1, ,2"));
    }

    @Test
    void 영_혹은_음수는_예외() {
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("0,1"));
        assertThrows(IllegalArgumentException.class, () -> StringCalculator.add("-1,2,3"));
    }
}