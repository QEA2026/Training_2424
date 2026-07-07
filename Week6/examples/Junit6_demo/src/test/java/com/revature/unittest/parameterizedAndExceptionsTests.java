package com.revature.unittest;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.*;

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

    @Nested
    @DisplayName("@CsvSource Examples")
    class CsvSourceExamples{
        @ParameterizedTest
        @CsvSource({
                "1, 2, 3",
                "0, 0, 0",
                "-1, 1, 0",
                "100, 200, 300",
                "-5, -10, -15"
        })
        @DisplayName("Addition with various inputs")
        void add_variousInputs_correctResult(int a, int b, int expected){
            assertEquals(expected, calculator.add(a,b));
        }

        @ParameterizedTest(name = "{0}+{1}={2}") //Custom Display Name!
        @CsvSource({
                "1, 1, 2",
                "2, 3, 5",
                "10, 20, 30"
        })
        @DisplayName("Addition with Custom Display Names")
        void add_withCustomDisplayName(int a, int b, int expected){
            assertEquals(expected, calculator.add(a,b));
        }

        @ParameterizedTest
        @CsvSource(value = {
                "hello | 5",
                "world | 5",
                "JUnit | 5",
                "testing | 7"
        }, delimiter = '|') //custom delimeter
        @DisplayName("String length with pipe delimiter")
        void stringLength_customerDelimiter(String input, int expectedLength){
            assertEquals(expectedLength, input.length());
        }
    }
}
