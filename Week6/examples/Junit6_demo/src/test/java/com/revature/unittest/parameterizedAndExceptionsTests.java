package com.revature.unittest;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertNull;
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

        @ParameterizedTest
        @ValueSource(strings = {"hello","world","JUnit6","Testing"})
        @DisplayName("Strings can be parameterized too")
        void stringLength_variousStrings_calculated(String input){
            assertTrue(input.length()>0);
        }

    }

    @Nested
    @DisplayName("Null and Empty Source Examples")
    class NullEmptyExamples {

        @ParameterizedTest
        @NullSource
        @DisplayName("Null Input Handling")
        void handleNull_nullInput_handled(String input){
            assertNull(input);
        }

        @ParameterizedTest
        @EmptySource
        @DisplayName("Empty String Handling")
        void handleEmpty_emptyInput_handled(String input){
            assertTrue(input.isEmpty());
        }

        @ParameterizedTest
        @NullAndEmptySource
        @ValueSource(strings = {"", "  ", "\t","\n"})
        @DisplayName(("Blank Strings Should Be Rejected"))
        void validateInput_blankInputs_rejected(String input){
            //combine source for comprehensive blank checking
            assertTrue(input==null || input.trim().isEmpty());
        }
    }
}
