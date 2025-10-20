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

}