package com.revature.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("JUnit6 Assertions Comprehensive Demo")
public class demo_assertions_comprehensive {

    @Test
    @DisplayName("assertEquals - Comparing Values")
    void demonstrateEquals(){
        //Primitive comparison
        assertEquals(4,2+2);
        assertEquals(4,2+2,"Basic Math should work");

        //String Comparisons
        String expected = "hello world";
        String actual = "hello " + "world";
        assertEquals(expected,actual);

        //object comparison
        Integer num1 = Integer.valueOf(100);
        Integer num2 = Integer.valueOf(100);
        assertEquals(num1,num2);
    }

    @Test
    @DisplayName("assertEquals with delta - Floating point comparison")
    void demonstrateFloatingPointComparison() {
        double result = 0.1 + 0.2; //This is NOT exactly 0.3 due to IEEE 754!

        //BAD: this might fail due to floating point precision
        //assertEquals(0.3,result) //Don't do this

        //Good: Use delta (tolerance) for floating-point precision
        assertEquals(0.29999999, result, 0.0001, "should be approximately 0.3");

        //Another example: PI comparison
        assertEquals(3.14159,Math.PI, 0.00001);
    }
}
