package com.revature.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

//@DisplayName provides human-readable test names in reports
@DisplayName("Calculator Basic Tests - JUnit6 Fundamentals")
class Junit6_demo_basics {
    // The System Under Test (SUT)
    private final Calculator calculator = new Calculator();

    //Basic Test Structure

    @Test
    @DisplayName("Adding two positive numbers returns their sum")
    void add_twoPositiveNumbers_returnsSum(){
        //ARRANGE - Set up the test data
        int a = 5;
        int b = 3;

        //ACT - Execute the method under test
        int result = calculator.add(a,b);

        //ASSERT - Verify the outcome
        assertEquals(8, result, "5+3 should equal 8");
    }

}
