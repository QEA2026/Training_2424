package com.revature;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Demo: Element Interactions in Selenium
 * 1. WebElement represents any HTML element
 * 2. Basic interactions: click, sendKeys, clear
 * 3. Information getters: getText, getAttribute, getCssValue
 * 4. State checks: isDisplayed, isEnabled, isSelected
 *
 * TEST site: https://the-internet.herokuapp.com
 */

@DisplayName("Element Interactions Demo")
public class demo_element_interactionsTests {

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

    //1. Basic Click Operations
    @Test
    @DisplayName(("click() - Basic button click"))
    void click_basicButton() {
        /* click() simulates a mouse click on the element
         * works on buttons, links, checkboxes, etc.
         */
        driver.get(BASE_URL + "/add_remove_elements/");

        //Find and click the "Add Element" button
        WebElement addButton = driver.findElement(
                By.xpath("//button[text()='Add Element']")
        );

        //Before clicking
        int elementsBefore = driver.findElements(By.className("added-manually")).size();
        System.out.println("Elements before click: " +elementsBefore);

        //click the button
        addButton.click();

        //After clicking
        int elementsAfter = driver.findElements(
                By.className("added-manually")).size();
        System.out.println("Elements after click: " + elementsAfter);

        assertEquals(elementsBefore +1, elementsAfter);
    }

    @Test
    @DisplayName("click() - Link navigation")
    void click_linkNavigation(){
        driver.get(BASE_URL);

        //Find and click a link
        WebElement link =driver.findElement(
                By.linkText("Form Authentication")
        );
        link.click();

        //verify navigation occurred
        assertTrue(driver.getCurrentUrl().contains("login"));
    }

    //2: Text Input Operations
    @Test
    @DisplayName("sendKeys() - Type text into input")
    void sendKeys_typeText(){
        /*
        *sendKeys() types text into input fields
        * works with text fields, textareas, etc.
         */

        driver.get(BASE_URL + "/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        //clear the field first
        usernameInput.clear();

        //Type into fields
        usernameInput.sendKeys("tomsmith");
        passwordInput.sendKeys("SuperSecretPassword!");

        //verify text was entered
        assertEquals("tomsmith", usernameInput.getAttribute("value"));
        assertEquals("SuperSecretPassword!", passwordInput.getAttribute("value"));

        System.out.println("Text Entered successfully!");
    }

    @Test
    @DisplayName("sendKeys() - Special Keys")
    void snedKeys_specialKeys() {

        //Keys enum provides special keys like ENTER, TAB, etc.

        driver.get(BASE_URL + "/login");

        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));

        //type and press TAB to move to next field
        usernameInput.sendKeys("tomsmith");
        usernameInput.sendKeys(Keys.TAB);

        //Type password and press ENTER to submit
        passwordInput.sendKeys("SuperSecretPassword!");
        passwordInput.sendKeys(Keys.ENTER);

        //Verify the login occurred
        System.out.println("Current URL after login: "+driver.getCurrentUrl());
    }

    //Section 3: getting element Information
    @Test
    @DisplayName("getText() - Get visible text")
    void getText_getVisibleText(){
    /*
    getText() returns the visible text of an element
    does not include hidden text or attribute values
     */

    driver.get(BASE_URL + "/login");

    WebElement heading = driver.findElement(By.tagName("h2"));
    String headingText = heading.getText();

    System.out.println("Heading Text: "+ headingText);
    assertEquals("Login Page",headingText);

    //Get text from Paragraph
    WebElement subheading = driver.findElement(By.tagName("h4"));
    System.out.println("Subheading: " +subheading.getText());

    }

    @Test
    @DisplayName("getAttribute() - Get attribute values")
    void getAttribute_getAttributeValues(){
        //getAttribute() retrieves HTML attribute values
        //Common attributes: id, class, name, href, value, placeholder

        driver.get(BASE_URL + "/login");

        WebElement usernameInput = driver.findElement(By.id("username"));

        //get various attributes
        String id = usernameInput.getAttribute("id");
        String type = usernameInput.getAttribute("type");
        String name = usernameInput.getAttribute("name");

        System.out.println("ID: " + id);
        System.out.println("Type: " + type);
        System.out.println("Name: " + name);

        assertEquals("username", id);
        assertEquals("text",type);

        //Get href from a link
        WebElement link = driver.findElement(By.xpath("//a[contains(text(),'Elemental')]"));
        String href = link.getAttribute("href");
        System.out.println("Link href: " +href);
    }


}
