package day04Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait{

    public static void main(String[] args) {

        /*
         * ============================================================
         * Explicit Wait in Selenium
         * ============================================================
         *
         * Definition:
         * Explicit Wait is a Selenium wait that waits for a
         * specific condition to be true before performing an action.
         *
         * It is a Dynamic Wait because Selenium waits only until
         * the required condition is met. If the condition is met
         * before the given time, Selenium continues immediately.
         *
         * Syntax:
         * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         * wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id")));
         *
         * Example:
         * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         * wait.until(ExpectedConditions.elementToBeClickable(By.id("login")));
         *
         * Where is Explicit Wait found?
         * - Package : org.openqa.selenium.support.ui
         * - Class   : WebDriverWait
         * - Helper Class : ExpectedConditions
         * - Uses : Duration class from java.time package
         *
         * Advantages:
         * 1. Waits only for the required element or condition.
         * 2. Faster than Thread.sleep().
         * 3. Improves test reliability.
         * 4. Reduces unnecessary waiting time.
         * 5. Best for dynamic web applications.
         *
         * Disadvantages:
         * 1. Slightly more code than Implicit Wait.
         * 2. Must be written for each required element.
         * 3. Beginners may find it difficult at first.
         * 4. Wrong condition can cause TimeoutException.
         * 5. Requires knowledge of ExpectedConditions.
         *
         * Best Use:
         * - Dynamic web applications.
         * - AJAX applications.
         * - Elements that load after some time.
         * - Professional Selenium automation projects.
         *
         * Avoid in:
         * - Very small scripts where all elements load instantly.
         *
         * Common ExpectedConditions:
         * - visibilityOfElementLocated()
         * - elementToBeClickable()
         * - presenceOfElementLocated()
         * - titleContains()
         * - alertIsPresent()
         * - textToBePresentInElement()
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Create Explicit Wait with a maximum wait time of 10 seconds
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Open the OrangeHRM demo website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Wait until the Username field is visible, then enter the username
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
                .sendKeys("Admin");

        // Wait until the Password field is visible, then enter the password
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("password")))
                .sendKeys("admin123");

        // Wait until the Login button is clickable, then click it
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@type='submit']")))
                .click();

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}