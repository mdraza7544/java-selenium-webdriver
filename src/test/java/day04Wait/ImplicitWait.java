package day04Wait;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ImplicitWait {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Implicit Wait in Selenium
         * ============================================================
         *
         * Definition:
         * Implicit Wait is a Selenium wait that tells WebDriver
         * to wait for a specified time before throwing a
         * NoSuchElementException.
         *
         * It is a Dynamic Wait because Selenium waits only
         * until the element is found. If the element appears
         * before the given time, Selenium continues immediately.
         *
         * Syntax:
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         *
         * Example:
         * driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         *
         * Where is Implicit Wait found?
         * - Package : java.time
         * - Class   : Duration
         * - Selenium Method :
         *   driver.manage().timeouts().implicitlyWait()
         *
         * Advantages:
         * 1. Easy to use.
         * 2. Dynamic wait (does not always wait the full time).
         * 3. Reduces test failure due to slow loading.
         * 4. Improves automation reliability.
         * 5. Applied globally to all findElement() calls.
         *
         * Disadvantages:
         * 1. Applies to all elements, even when not needed.
         * 2. Cannot wait for specific conditions.
         * 3. Not suitable for complex applications.
         * 4. Can make debugging difficult.
         * 5. Mixing with Explicit Wait is not recommended.
         *
         * Best Use:
         * - Small automation projects.
         * - Pages where elements load at similar speeds.
         * - Basic Selenium scripts.
         *
         * Avoid in:
         * - Large automation frameworks.
         * - Complex web applications.
         * - Waiting for specific conditions.
         *
         * Better Alternative:
         * - Explicit Wait
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Set Implicit Wait for 10 seconds
        // Selenium will wait up to 10 seconds to find any element
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open the OrangeHRM demo website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Find the Username field and enter the username
        driver.findElement(By.name("username")).sendKeys("Admin");

        // Find the Password field and enter the password
        driver.findElement(By.name("password")).sendKeys("admin123");

        // Find the Login button and click it
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}