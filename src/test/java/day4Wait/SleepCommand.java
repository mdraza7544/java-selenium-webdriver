package day4Wait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SleepCommand {

    public static void main(String[] args) throws InterruptedException {

        /*
         * ============================================================
         * Thread.sleep() in Java
         * ============================================================
         *
         * Definition:
         * Thread.sleep() is a Java method that pauses the execution
         * of the current program (thread) for a specified time.
         *
         * Syntax:
         * Thread.sleep(timeInMilliseconds);
         *
         * Example:
         * Thread.sleep(5000);
         *
         * 5000 milliseconds = 5 seconds
         *
         * Where is Thread.sleep() found?
         * - Package : java.lang
         * - Class   : Thread
         * - Method  : sleep()
         * - Type    : Static Method
         *
         * Note:
         * java.lang package is imported automatically,
         * so no need to import the Thread class.
         *
         * Advantages:
         * 1. Very easy to use.
         * 2. Creates a fixed (static) wait.
         * 3. Helpful for beginners.
         * 4. Useful for debugging automation scripts.
         * 5. Simple one-line syntax.
         *
         * Disadvantages:
         * 1. Static wait (always waits the full time).
         * 2. Makes test execution slower.
         * 3. Not recommended for real automation projects.
         * 4. Reduces test performance.
         * 5. Requires InterruptedException.
         *
         * Best Use:
         * - Learning Selenium.
         * - Debugging.
         * - Small demo programs.
         *
         * Avoid in:
         * - Real automation projects.
         * - Waiting for web elements.
         *
         * Better Alternatives:
         * - Implicit Wait
         * - Explicit Wait
         * - Fluent Wait
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open the OrangeHRM demo website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Wait for 5 seconds
        // Thread.sleep() pauses the program for 5000 milliseconds
        Thread.sleep(5000);

        // Click on the OrangeHRM link
        driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();

        // Wait for 3 seconds so the new page can open properly
        Thread.sleep(3000);

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}