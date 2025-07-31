package ru.job4j.ex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FactorialTest {

    @Test
    void whenNumberIsNegativeThenThrowIllegalArgumentException() {
        Factorial factorial = new Factorial();

        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> factorial.calc(-1),
                "Ожидается, что будет выброшено IllegalArgumentException при передаче отрицательного числа"
        );

        assertEquals("Number could not be less than 0", exception.getMessage());
    }

    @Test
    void whenNumberIsZeroThenReturnOne() {
        Factorial factorial = new Factorial();
        int result = factorial.calc(0);
        assertEquals(1, result, "Факториал 0 должен быть равен 1");
    }

    @Test
    void whenNumberIsPositiveThenReturnCorrectFactorial() {
        Factorial factorial = new Factorial();
        assertEquals(1, factorial.calc(1), "Факториал 1 = 1");
        assertEquals(2, factorial.calc(2), "Факториал 2 = 2");
        assertEquals(6, factorial.calc(3), "Факториал 3 = 6");
        assertEquals(24, factorial.calc(4), "Факториал 4 = 24");
    }
}