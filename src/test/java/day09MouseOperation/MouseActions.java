package day09MouseOperation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle Mouse Actions in Selenium
         * ============================================================
         *
         * Definition:
         * Mouse Actions are used to simulate different mouse
         * operations such as click, double click, right click,
         * drag & drop, mouse hover, etc.
         *
         * Methods Used:
         *
         * 1. click()
         * 2. doubleClick()
         * 3. contextClick()
         *
         * Package :
         * org.openqa.selenium.interactions
         *
         * Class :
         * Actions
         *
         * Advantages:
         *
         * 1. Automates complex mouse operations.
         * 2. Supports user-like interactions.
         * 3. Useful for menus, buttons and drag-drop.
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open DemoQA Website
        driver.get("https://demoqa.com/buttons");

        // Create Actions Class Object
        Actions act = new Actions(driver);

        /*
         * ============================================================
         * Approach 1 : Perform Double Click
         * ============================================================
         */

        WebElement doubleClickBtn = driver.findElement(By.id("doubleClickBtn"));

        act.doubleClick(doubleClickBtn).perform();

        System.out.println("Double Click Performed Successfully.");

        System.out.println(driver.findElement(By.id("doubleClickMessage")).getText());

        /*
         * ============================================================
         * Approach 2 : Perform Right Click
         * ============================================================
         */

        WebElement rightClickBtn = driver.findElement(By.id("rightClickBtn"));

        act.contextClick(rightClickBtn).perform();

        System.out.println("Right Click Performed Successfully.");

        System.out.println(driver.findElement(By.id("rightClickMessage")).getText());

        /*
         * ============================================================
         * Approach 3 : Perform Normal Click
         * ============================================================
         */

        WebElement clickBtn = driver.findElement(
                By.xpath("//button[text()='Click Me']"));

        act.click(clickBtn).perform();

        System.out.println("Normal Click Performed Successfully.");

        System.out.println(driver.findElement(By.id("dynamicClickMessage")).getText());

        // Close Browser
        driver.quit();
    }
}