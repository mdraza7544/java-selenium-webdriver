package day12ToolTip;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTip {

    public static void main(String[] args) throws InterruptedException {

        /*
         * ============================================================
         * Handle Tooltip in Selenium
         * ============================================================
         *
         * Definition:
         * A Tooltip is a small pop-up message that appears when
         * the mouse pointer is placed over a web element.
         *
         * Selenium handles tooltips by performing a mouse hover
         * action using the Actions class and then capturing
         * the tooltip text.
         *
         * Methods Used:
         *
         * 1. moveToElement()
         *    - Moves the mouse pointer to an element.
         *
         * 2. perform()
         *    - Executes the mouse action.
         *
         * 3. getText()
         *    - Retrieves the tooltip text.
         *
         * Package :
         * org.openqa.selenium.interactions
         *
         * Class :
         * Actions
         *
         * Advantages:
         *
         * 1. Verifies tooltip messages.
         * 2. Useful for UI Testing.
         * 3. Supports dynamic tooltips.
         *
         * Best Use:
         *
         * - Buttons
         * - Text Fields
         * - Links
         * - Icons
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open DemoQA Tooltip Page
        driver.get("https://demoqa.com/tool-tips");

        // Create Actions Object
        Actions act = new Actions(driver);

        /*
         * ============================================================
         * Approach 1 : Handle Button Tooltip
         * ============================================================
         */

        // Locate the Button
        WebElement button = driver.findElement(By.id("toolTipButton"));

        // Mouse Hover on Button
        act.moveToElement(button).perform();

        // Wait for Tooltip to Appear
        Thread.sleep(1000);

        // Capture Tooltip Text
        WebElement tooltip = driver.findElement(By.className("tooltip-inner"));

        // Print Tooltip Text
        System.out.println("Tooltip Text : " + tooltip.getText());

        // Close Browser
        driver.quit();
    }
}