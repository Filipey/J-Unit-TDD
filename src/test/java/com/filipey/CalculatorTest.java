package com.filipey;


import com.filipey.models.Calculator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CalculatorTest {

    @Mock
    Calculator calculator;

    @BeforeEach
    public  void setUp() {
        calculator = new Calculator();
    }

    @Test
    @DisplayName("Should sum two numbers correctly")
    public void shouldSumTwoNumbers() {
        // cenario
        int num = 10, num2 = 5;

        // execução
        int result = calculator.sum(num, num2);

        // verificação
        Assertions.assertThat(result).isEqualTo(15);

    }

    @Test
    @DisplayName("Should dont sum negative numbers")
    public void shouldDontSumNegativeNumbers() {
        int num = -10, num2 = 5;

        org.junit.jupiter.api.Assertions
                .assertThrows(RuntimeException.class, () -> calculator.sum(num, num2));

    }

    @Test
    @DisplayName("Should subtract two numbers correctly")
    public void shouldSubTwoNumbers() {
        int num = 20, num2 = 15;

        int result = calculator.sub(num, num2);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Should multiply two numbers correctly")
    public void shouldMultTwoNumbers() {
        int num = 10, num2 = 2;

        int result = calculator.mult(num, num2);

        Assertions.assertThat(result).isEqualTo(20);
    }

    @Test
    @DisplayName("Should divide two numbers correctly")
    public void shouldDivTwoNumbers() {
        int num = 10, num2 = 2;

        float result = calculator.div(num, num2);

        Assertions.assertThat(result).isEqualTo(5);
    }

    @Test
    @DisplayName("Should dont divide a number by 0")
    public void shouldDontDivideByZero() {
        int num = 10, num2 = 0;

        org.junit.jupiter.api.Assertions
                .assertThrows(ArithmeticException.class, () -> calculator.div(num, num2));

    }
}
