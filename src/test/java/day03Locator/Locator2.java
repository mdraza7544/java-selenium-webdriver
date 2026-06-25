package day03Locator;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator2 {

    public static void main(String[] args) throws InterruptedException {

        // Open Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        /*
         * WRONG WAY:
         * Using findElement() with tagName("input") always returns
         * the first matching input element on the page.
         * Since username, password, and login button are all input tags,
         * Selenium will keep selecting the first input field.
         */

//      driver.findElement(By.tagName("input")).sendKeys("standard_user");
//      driver.findElement(By.tagName("input")).sendKeys("secret_sauce");
//      driver.findElement(By.tagName("input")).click();

        /*
         * CORRECT WAY:
         * Use findElements() to get all input elements and store them in a List.
         * Then access each element by its index.
         */

        // Find all input elements on the page
        List<WebElement> inputFields = driver.findElements(By.tagName("input"));

        // Enter username in the first input field
        inputFields.get(0).sendKeys("standard_user");

        // Enter password in the second input field
        inputFields.get(1).sendKeys("secret_sauce");

        // Click the login button (third input element)
        inputFields.get(2).click();

        // Wait for 5 seconds to see the result
        Thread.sleep(5000);

        // Close the browser
        driver.quit();
    }
}