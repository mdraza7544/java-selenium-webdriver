package day11Alerts;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PromptAlert {

    public static void main(String[] args) throws InterruptedException {
 
        /*
         * ============================================================
         * Handle Alerts in Selenium
         * ============================================================
         *
         * Definition:
         * An Alert is a small pop-up window that appears to display
         * a message or request user confirmation or input.
         *
         * Selenium handles alerts using the Alert interface.
         *
         * Types of Alerts:
         *
         * 1. Simple Alert
         * 2. Confirmation Alert
         * 3. Prompt Alert
         *
         * Methods Used:
         *
         * 1. switchTo().alert()
         *    - Switches control to the alert.
         *
         * 2. accept()
         *    - Clicks the OK button.
         *
         * 3. dismiss()
         *    - Clicks the Cancel button.
         *
         * 4. getText()
         *    - Returns the alert message.
         *
         * 5. sendKeys()
         *    - Enters text into a prompt alert.
         *
         * Package   : org.openqa.selenium
         * Interface : Alert
         *
         * Advantages:
         *
         * 1. Handles browser alerts easily.
         * 2. Supports confirmation and prompt dialogs.
         * 3. Useful in real-world automation.
         *
         * Best Use:
         *
         * - Delete Confirmation
         * - Warning Messages
         * - Login Prompts
         * - JavaScript Alerts
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Website
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");



        /*
         * ============================================================
         * Approach 3 : Handle Prompt Alert
         * ============================================================
         */

        // Click Prompt Alert Button
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        
        Alert alert = driver.switchTo().alert();

        // Switch to Alert
        alert = driver.switchTo().alert();

        // Print Alert Message
        System.out.println("Prompt Alert : " + alert.getText());

        // Enter Text
        alert.sendKeys("Md Ashif");

        // Click OK
        alert.accept();

        Thread.sleep(2000);

        // Close Browser
        driver.quit();
    }
}