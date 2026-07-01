package day06DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

    public static void main(String[] args) throws InterruptedException {

        /*
         * ============================================================
         * Handle DropDown in Selenium
         * ============================================================
         *
         * Definition:
         * A DropDown is a web element that allows the user to
         * select one or more options from a list.
         *
         * Selenium provides the Select class to handle
         * HTML <select> dropdown elements.
         *
         * Methods Used:
         *
         * 1. selectByVisibleText()
         *    - Selects an option using the visible text.
         *
         * 2. selectByValue()
         *    - Selects an option using the value attribute.
         *
         * 3. selectByIndex()
         *    - Selects an option using its index.
         *
         * 4. getOptions()
         *    - Returns all available options in the dropdown.
         *
         * 5. getFirstSelectedOption()
         *    - Returns the currently selected option.
         *
         * 6. isMultiple()
         *    - Checks whether the dropdown supports multiple selection.
         *
         * Where are these methods found?
         *
         * Package : org.openqa.selenium.support.ui
         * Class   : Select
         *
         * Advantages:
         *
         * 1. Easy to automate dropdown elements.
         * 2. Supports selection by text, value, and index.
         * 3. Can retrieve all dropdown options.
         * 4. Supports both single-select and multi-select dropdowns.
         * 5. Widely used in real-world automation projects.
         *
         * Disadvantages:
         *
         * 1. Works only with HTML <select> elements.
         * 2. Cannot handle custom dropdowns built using
         *    <div>, <span>, etc.
         * 3. Requires different techniques for Bootstrap
         *    and React dropdowns.
         *
         * Best Use:
         *
         * - Country selection
         * - State selection
         * - Language selection
         * - Category selection
         * - Any HTML <select> dropdown
         *
         * ============================================================
         */

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Test Automation Practice Website
        driver.get("https://testautomationpractice.blogspot.com/");

        // Locate Country Dropdown
        WebElement dropdown = driver.findElement(By.id("country"));

        // Create Select Class Object
        Select select = new Select(dropdown);

        /*
         * ============================================================
         * Approach 1 : Select Option by Visible Text
         * ============================================================
         */

        // select.selectByVisibleText("India");
        // Thread.sleep(2000);

        /*
         * ============================================================
         * Approach 2 : Select Option by Value
         * ============================================================
         */

        // select.selectByValue("india");
        // Thread.sleep(2000);

        /*
         * ============================================================
         * Approach 3 : Select Option by Index
         * ============================================================
         */

        // select.selectByIndex(2);
        // Thread.sleep(2000);

        /*
         * ============================================================
         * Approach 4 : Capture All Dropdown Options
         * ============================================================
         */

        // Capture all options from the dropdown
        List<WebElement> options = select.getOptions();

        // Print total number of options
        System.out.println("Total Options : " + options.size());

        System.out.println("\nDropdown Options are:");

        // Print each option using For-Each Loop
        for (WebElement option : options) {
            System.out.println(option.getText());

         // Check whether the option is India
                if (option.getText().equals("India")) {
                    System.out.println("India option found.");
                    option.click();
                    break; // Exit the loop after clicking
                }  
        }

        // Close the Browser
        driver.quit();
    }
}