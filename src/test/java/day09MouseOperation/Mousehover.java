package day09MouseOperation;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Mousehover {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle Mouse Hover Action in Selenium
         * ============================================================
         *
         * Definition:
         * Mouse Hover is used to move the mouse pointer over
         * a web element without clicking it.
         *
         * It is commonly used to display hidden menus,
         * submenus, tooltips, and dropdown options.
         *
         * Method Used:
         *
         * moveToElement(WebElement)
         *      - Moves the mouse pointer to the specified element.
         *
         * Package :
         * org.openqa.selenium.interactions
         *
         * Class :
         * Actions
         *
         * Advantages:
         *
         * 1. Opens hidden menus.
         * 2. Displays tooltips.
         * 3. Handles nested menus.
         * 4. Simulates real user interaction.
         *
         * Best Use:
         *
         * - Navigation Menus
         * - Dropdown Menus
         * - Tooltips
         * - Hidden Elements
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open DemoQA Menu Page
        driver.get("https://demoqa.com/menu");

        // Create Actions Class Object
        Actions act = new Actions(driver);

        /*
         * ============================================================
         * Approach 1 : Mouse Hover on Main Item 2
         * ============================================================
         */

        WebElement mainItem2 = driver.findElement(By.xpath("//a[text()='Main Item 2']"));

        act.moveToElement(mainItem2).perform();

        System.out.println("Mouse Hover Performed on Main Item 2");

        /*
         * ============================================================
         * Approach 2 : Mouse Hover on SUB SUB LIST »
         * ============================================================
         */

        WebElement subSubList = driver.findElement(By.xpath("//a[text()='SUB SUB LIST »']"));

        act.moveToElement(subSubList).perform();

        System.out.println("Mouse Hover Performed on SUB SUB LIST");

        /*
         * ============================================================
         * Approach 3 : Click on Sub Sub Item 2
         * ============================================================
         */

        WebElement subSubItem2 = driver.findElement(By.xpath("//a[text()='Sub Sub Item 2']"));

        subSubItem2.click();

        System.out.println("Sub Sub Item 2 Clicked Successfully");

        // Close Browser
//        driver.quit();
    }
}