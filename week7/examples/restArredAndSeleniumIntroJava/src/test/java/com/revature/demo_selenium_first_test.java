package com.revature;

//These are the simplest Selenium Tests
// WebDriver is the main interface for the browser interaction
// Always close the driver when done (finally block @AfterEach)
//get() navigates to URL, getTitle() gets the page title...


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("First Selenium WebDriver Tests")
public class demo_selenium_first_test {

    private WebDriver driver;

    @BeforeEach
    void setUp() {

        //for now, we'll use manual driver setup
        //tomorrow we will see WebDriverManager for automatic setup

        //ChromeDriver requires:
        //Chrome browser installed
        //ChromeDriver executable (matching Chrome version)
        //System property set OR ChomeDriver in PATH

        //WebDriverManager.chromedriver.setup()
        //could need above

        driver = new ChromeDriver();

        //Maximize browser window()
        driver.manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        //alwaus close the driver!
        //quit() closes all windows and ends the session
        //close() only closes current window()
        //forgetting to quit() leaves browser processes running
        if(driver != null){
            driver.quit();
        }
    }

    //Basic Navigation
    @Test
    @DisplayName("Navigate to website and verify title")
    void navigateToWebsite_verifyTitle(){
        //1. open a URL
        //2. get the page title
        //3. assert it matches expected

        //navigate to the website
        driver.get("https://www.selenium.dev/");

        // get page title
        String title = driver.getTitle();
        System.out.println("Page Title: " + title);

        //Verify title
        assertTrue(title.contains("Selenium"),
                "Title shoudl contain 'Selenium'");
    }

    @Test
    @DisplayName("Get current URL after navigation")
    void navigateToWebsite_verifyUrl(){
        //getCurrentUrl() returns the current page URL
        //Useful for verifyng redirects or navigation

        driver.get("https://www.selenium.dev/documentation");

        String currentUrl = driver.getCurrentUrl();
        System.out.println("Current URL: " + currentUrl);

        assertTrue(currentUrl.contains("documentation"),
                "URL should contain 'documentation'");
    }

}
