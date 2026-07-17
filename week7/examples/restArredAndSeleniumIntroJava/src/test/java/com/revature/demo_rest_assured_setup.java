package com.revature;

//REST assured Setup and First Tests

import io.restassured.RestAssured;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@DisplayName("REST Assured Setup Demo")
public class demo_rest_assured_setup {

    //Setup

    @BeforeAll
    static void setup(){
        //configure base URI once for all tests
        //This is like setting baseUrl in Postman

        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";

        //Optional: Enable loggin and debugging
        RestAssured.enableLoggingOfRequestAndResponseIfValidationFails();


    }
    @AfterAll
    static void teardown(){
        //Reset REST Assured to Defaults
        RestAssured.reset();
    }

    //First REST Assured Test
    @Test
    @DisplayName("First REST Assured Test - GET a post")
    void firstTest_getPost_returnSuccessfully() {

        given() //Setup
            .log().all() //Log the request (optional)
        .when() //Action
            .get("/posts/1")
        .then() //Validation
            .log().all() //log the response
            .statusCode(200);
    }




}
