package com.revature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Demo: XPath Locators in Selenium
 *
 * 1. XPath is the most flexible locator strategy
 * 2. Prefer relative XPATH over absolute
 * 3. XPath functions enable complex element finding
 * 4. XPath axes navigate the DOM tree
 *
 * TEST site: https://the-internet.herokuapp.com
 */

@DisplayName("XPath Locators Demo")
public class demo_xpath_locatorsTesting {


    private WebDriver driver;
    private static final String BASE_URL = "https://the-internet.herokuapp.com";

    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if(driver != null){
            driver.quit();
        }
    }

    @Test
    @DisplayName("Absolue XPath - starts from root")
    void absoluteXpath_startsFromRoot(){
        /*
        Absolute XPath starts with single slash (/)
        Starts from document root

        Problems:
        - Very brittle -breaks id DOM structure changes
        - Hard to read and maintain
        - AVOID in production code
         */

        driver.get(BASE_URL);

        //Absolute XPath - BAD PRACTICE (but shows the concept)
        // Example: /html/body/div[2]/div/h1
        // this would break if any parent element changes

        //let's find the heading using absolute path
        try{
            WebElement heading = driver.findElement(
                    By.xpath("/html/body/div[2]/div/h1")
            );
            System.out.println("Found heading: " + heading.getText());
        } catch (NoSuchElementException e ){
            System.out.println("Absolute XPath is brittle - element not found");
        }
    }

    @Test
    @DisplayName("relative XPath - starts with //")
    void relativeXpath_startsAnywhere(){
        /*
        Relative XPath starts with double slash (//)
        Searches entire document for matching elements

        MUCH BETTER:
        -more maintainable
        -survives DOM restructuring
        -preferred in production
         */

        driver.get(BASE_URL);

        //Relative XPath - GOOD PRACTICE
        WebElement heading = driver.findElement(
                By.xpath("//h1[@class='heading']")
        );
        System.out.println("Heading text: " + heading.getText());
        assertNotNull(heading.getText());
    }
}
