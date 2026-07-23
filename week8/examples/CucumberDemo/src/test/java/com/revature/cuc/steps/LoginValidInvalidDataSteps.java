package com.revature.cuc.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginValidInvalidDataSteps {

    private WebDriver driver;
    private static final String LOGIN_URL = "https://the-internet.hereokuapp.com/login";

    //---------Hooks----------------

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        if(driver!= null){
            driver.quit();
        }
    }

    //---------------background Steps---------------------

    @Given("the application is running")
    public void the_application_is_running() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the test database is seeded with users")
    public void the_test_database_is_seeded_with_users() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //---------------------Scenario Steps --------------------------
    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @When("the user enters username {string}")
    public void the_user_enters_username(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user enters password {string}")
    public void the_user_enters_password(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user clicks the login button")
    public void the_user_clicks_the_login_button() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //---------------------------Outcome Validation-------------------------
    @Then("the {string} should be displayed")
    public void the_should_be_displayed(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @And("the user should be on the {string} page")
    public void the_user_should_be_on_the_page(String string) {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
