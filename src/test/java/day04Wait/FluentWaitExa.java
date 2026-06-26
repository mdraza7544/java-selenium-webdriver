package day04Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.WebElement;

public class FluentWaitExa{

    public static void main(String[] args) {

        /*
         * ============================================================
         * Fluent Wait in Selenium
         * ============================================================
         *
         * Definition:
         * Fluent Wait is a Selenium wait that waits for a
         * specific condition and checks for the element at
         * regular time intervals (polling time).
         *
         * It is a Dynamic Wait because Selenium waits only
         * until the required element is found. If the element
         * appears before the maximum wait time, Selenium
         * continues immediately.
         *
         * Syntax:
         *
         * FluentWait<WebDriver> wait = new FluentWait<>(driver)
         *      .withTimeout(Duration.ofSeconds(20))
         *      .pollingEvery(Duration.ofSeconds(2))
         *      .ignoring(NoSuchElementException.class);
         *
         * Example:
         * wait.until(driver ->
         *      driver.findElement(By.name("username")));
         *
         * Where is Fluent Wait found?
         * - Package : org.openqa.selenium.support.ui
         * - Class   : FluentWait
         * - Uses    : Duration class from java.time package
         *
         * Advantages:
         * 1. Dynamic wait.
         * 2. Allows custom polling time.
         * 3. Can ignore specific exceptions.
         * 4. Faster than Thread.sleep().
         * 5. Best for elements that take different times to load.
         *
         * Disadvantages:
         * 1. More complex than Implicit Wait.
         * 2. Requires more code.
         * 3. Beginners may find it difficult.
         * 4. Wrong polling time can reduce performance.
         * 5. Needs proper configuration.
         *
         * Best Use:
         * - Dynamic web applications.
         * - AJAX applications.
         * - Slow loading elements.
         * - Large Selenium automation projects.
         *
         * Avoid in:
         * - Very simple automation scripts.
         *
         * Important Methods:
         * - withTimeout()      -> Maximum waiting time
         * - pollingEvery()     -> Check interval
         * - ignoring()         -> Ignore specific exceptions
         * - until()            -> Wait until condition is true
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open the OrangeHRM demo website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Create Fluent Wait
        FluentWait<WebDriver> wait = new FluentWait<>(driver)
                // Maximum wait time is 20 seconds
                .withTimeout(Duration.ofSeconds(20))

                // Check for the element every 2 seconds
                .pollingEvery(Duration.ofSeconds(2))

                // Ignore exception if element is not found
                .ignoring(org.openqa.selenium.NoSuchElementException.class);

        // Wait until the Username field is found
        WebElement username = wait.until(driver1 ->
                driver1.findElement(By.name("username")));

        // Enter username
        username.sendKeys("Admin");

        // Find Password field and enter password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Click Login button
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}