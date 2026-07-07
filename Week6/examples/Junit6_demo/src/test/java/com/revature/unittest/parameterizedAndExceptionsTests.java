package com.revature.unittest;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class parameterizedAndExceptionsTests {
    // Parameterized Tests - Data-Driven Testing
    //@ParameterizedTest replaces @Test for data-driven tests
    //Various soruces: @ValueSource, @CsvSource, @MethodSource, @EnumSource
    //write logic once, run with many inputs
    //required dependency: junit-jupiter-params

    private final Calculator calculator = new Calculator();

    @Nested
    @DisplayName("@ValueSource Examples")
    class ValueSourceExamples{



        @ParameterizedTest
        @ValueSource(ints = {2, 4, 6, 8, 0, -2, 100})
        @DisplayName("Even numbers should be identified correctly")
        void isEven_evenNumbers_returnsTru(int number){
            assertTrue(calculator.isEven(number),number  + " should be even");
        }

    }
}
