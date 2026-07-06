package com.revature.unittest;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Test Lifecycle Demo")
public class demo_lifecycle_methods {

    //shared across test (set in @BeforaAll)
    private static String sharedResource;
    private static int testCounter;

    //Fresh for each test (set in @BeforeEach)
    private Calculator calculator;
    private StringBuilder testLog;

    //@BeforaAll - One-Time Class Setp

    @BeforeAll
    static void setUpClass(){
        System.out.println("@BeforeAll: Setting up test class ONCE");

        //simulate expensive setup
        sharedResource = "Database connection";
        testCounter = 0;

        // you might
        // - start a mock server
        // - open a database connection
        // - load a large test data file
        // - initialize heavy resources


    }

    @BeforeEach
    void setUp(TestInfo testInfo) {
        testCounter++;
        System.out.println("@BeforeEach: Preparing test # "+ testCounter);

        // Create fresh instances for each test
        calculator = new Calculator();
        testLog = new StringBuilder();
        testLog.append("Test started |");

        //this is where you would
        // - Create fresh object instances
        // - reset mocks
        // - prepare test-specific data
        // - start a transaction

    }

    //actual tests
    @Test
    @DisplayName("First test - Calculator is fresh")
    void testOne(){
        System.out.println("running test one ....");
        testLog.append("test one executed");
        assertEquals(5,calculator.add(2,3));
        assertNotNull(sharedResource);
    }

    @Test
    @DisplayName("Second test - Calculator is fresh again")
    void testTwo(){
        System.out.println("running test two ....");
        testLog.append("test two executed");

        //Even if test one modified calculator, we get a fresh one
        assertEquals(8,calculator.add(5,3));

    }
}
