package com.filipey;


import com.filipey.models.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    Calculator calculator;

    @Before
    public void setUp() {
        calculator = new Calculator();
    }

    @Test
    public void shouldSumTwoNumbers() {
        // cenario
        int num = 10, num2 = 5;

        // execução
        int result = calculator.sum(num, num2);

        // verificação
        Assertions.assertThat(result).isEqualTo(15);

    }

    @Test(expected = RuntimeException.class)
    public void shouldDontSumNegativeNumbers() {
        int num = -10, num2 = 5;

        int result = calculator.sum(num, num2);

    }

    @Test
    public void shouldSubTwoNumbers() {
        int num = 20, num2 = 15;

        int result = calculator.sub(num, num2);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    public void shouldMultiplyTwoNumbers() {
        int num = 10, num2 = 2;

        int result = calculator.mult(num, num2);

        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
    public void shouldDivideTwoNumbers() {
        int num = 10, num2 = 2;

        float result = calculator.div(num, num2);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test(expected = ArithmeticException.class)
    public void shouldDontDivideByZero() {
        int num = 10, num2 = 0;

        float result = calculator.div(num, num2);

    }
}
