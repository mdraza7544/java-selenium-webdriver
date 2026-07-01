
package day07Checkbox;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CheckBox {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle Checkboxes in Selenium
         * ============================================================
         *
         * Definition:
         * Checkbox Handling is used to select or deselect one
         * or more checkboxes available on a web page.
         *
         * Selenium provides different methods to interact with
         * checkboxes such as click(), isSelected(), isDisplayed(),
         * and isEnabled().
         *
         * Methods Used:
         *
         * 1. findElements()
         *    - Returns all matching checkbox elements.
         *
         * 2. click()
         *    - Selects or deselects a checkbox.
         *
         * 3. getText()
         *    - Returns the visible label text of the checkbox.
         *
         * 4. isSelected()
         *    - Checks whether the checkbox is selected.
         *
         * Where are these methods found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebElement
         * Methods   :
         *    - click()
         *    - getText()
         *    - isSelected()
         *
         * Advantages:
         *
         * 1. Easy to automate multiple checkboxes.
         * 2. Can select or deselect checkboxes.
         * 3. Supports dynamic checkbox selection.
         * 4. Useful in registration and form automation.
         * 5. Frequently used in real Selenium projects.
         *
         * Disadvantages:
         *
         * 1. Dynamic locators may change frequently.
         * 2. Wrong XPath may select unwanted checkboxes.
         * 3. Labels and checkboxes may have different locators.
         *
         * Best Use:
         *
         * - Registration Forms
         * - Survey Forms
         * - Multiple Selection Lists
         * - Filter Options
         * - Preference Selection
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Open Test Automation Practice Website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate all checkboxes
        List<WebElement> checkboxes = driver.findElements(
                By.xpath("//input[@class='form-check-input' and @type='checkbox']"));

        /*
         * ============================================================
         * Approach 1 : Select All Checkboxes Except
         *              Sunday and Saturday
         * ============================================================
         */

        // Iterate through all checkboxes
        for (WebElement check : checkboxes) {

            // Get the label text next to the checkbox
            String text = check.findElement(By.xpath("./following-sibling::label")).getText();

            // Check whether the checkbox is NOT Sunday and NOT Saturday
            if (!text.equals("Sunday") && !text.equals("Saturday")) {

                System.out.println("Selecting : " + text);

                // Select the checkbox
                check.click();
            }
        }

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}
