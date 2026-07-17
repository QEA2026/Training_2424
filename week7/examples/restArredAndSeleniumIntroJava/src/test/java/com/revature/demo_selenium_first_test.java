package com.revature;

//These are the simplest Selenium Tests
// WebDriver is the main interface for the browser interaction
// Always close the driver when done (finally block @AfterEach)
//get() navigates to URL, getTitle() gets the page title...


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

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

}
