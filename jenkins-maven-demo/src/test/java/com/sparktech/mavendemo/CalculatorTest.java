package com.sparktech.mavendemo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CalculatorTest {

    private final Calculator calculator = new Calculator();

    @Test
    void addsTwoNumbers() {
        assertEquals(15, calculator.add(10, 5));
    }

    @Test
    void subtractsTwoNumbers() {
        assertEquals(5, calculator.subtract(10, 5));
    }

    @Test
    void multipliesTwoNumbers() {
        assertEquals(50, calculator.multiply(10, 5));
    }

    @Test
    void dividesTwoNumbers() {
        assertEquals(2, calculator.divide(10, 5));
    }

    @Test
    void divideByZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calculator.divide(10, 0));
    }

    @Test
    void detectsEvenAndOdd() {
        assertTrue(calculator.isEven(4));
        assertFalse(calculator.isEven(7));
    }
}
