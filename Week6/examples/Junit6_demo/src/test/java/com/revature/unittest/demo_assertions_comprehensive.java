package com.revature.unittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    @DisplayName("assertNotEquals - Values should differ")
    void demonstrateNotEquals(){
        assertNotEquals("hello","world");
        assertNotEquals(1,2);
        assertNotEquals(null,"something");
    }

    //Boolean Assertions

    @Test
    @DisplayName("assertTrue/assertFalse - Boolean conditions")
    void demonstrateBooleanAssertions(){
        //assertTrue
        assertTrue(5>3, "5 should be greater than 3");
        assertTrue("Hello".startsWith("H"));
        assertTrue(List.of(1,2,3).contains(2));

        //assertFalse
        assertFalse(5<3, "3 should not be greater than 5");
        assertFalse("Hello".isEmpty());
        assertFalse(List.of(1,2,3).contains(99));
    }

    @Test
    @DisplayName("Why specific assertions beat assertTrue")
    void demonstrateSpecificVsGeneric(){
        int result = 7;
        // LESS INFORMATIVE: "expected: <true> but was <false>"
//        assertTrue(result==5);
        //MORE INFORMATIVE
        assertEquals(5,result, "Specific assertions give better messages");
    }

    //Null Assertions

    @Test
    @DisplayName("assertNull/assertNotNull - null checking")
    void demonstrateNullAssertions(){
        String nullValue = null;
        String nonNullValue = "exists";

        assertNull(nullValue,"Should be null");
        assertNotNull(nonNullValue,"Should not be null");

        //real-world example
        //assertNull(repository.findById(-1),"Non-existend ID returns null);
        //assertNotNull(repository.findById(1),"Exisitting ID returns object);
    }

    //Reference Assertions
    @Test
    @DisplayName("assertSame/assertNotSame = Reference comparison")
    void demonstrateReferenceAssertions(){
        String str1 = "hello";
        String str2 = str1; //same reference
        String str3 = new String("hello"); //Different object, same content

        //same reference
        assertSame(str1,str2,"should be the same object reference");

        //Different references, equal content
        assertEquals(str1,str3); //passes -same content
        assertNotSame(str1,str3); //passes - different objects

        //use assertSame w/ singletons, caching, object identity
        //use assertEquals with testing value equality
    }
}
