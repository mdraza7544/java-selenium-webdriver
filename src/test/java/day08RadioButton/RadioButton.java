
package day08RadioButton;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RadioButton {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle Radio Buttons in Selenium
         * ============================================================
         *
         * Definition:
         * Radio Button Handling is used to select one option
         * from a group of mutually exclusive choices.
         *
         * Unlike checkboxes, only one radio button can be
         * selected at a time within the same group.
         *
         * Methods Used:
         *
         * 1. findElements()
         *    - Returns all matching radio button elements.
         *
         * 2. click()
         *    - Selects the required radio button.
         *
         * 3. isSelected()
         *    - Checks whether the radio button is selected.
         *
         * 4. isDisplayed()
         *    - Checks whether the radio button is visible.
         *
         * 5. isEnabled()
         *    - Checks whether the radio button is enabled.
         *
         * Where are these methods found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebElement
         * Methods   :
         *    - click()
         *    - isSelected()
         *    - isDisplayed()
         *    - isEnabled()
         *
         * Advantages:
         *
         * 1. Easy to automate radio buttons.
         * 2. Allows selection of only one option.
         * 3. Useful in registration and survey forms.
         * 4. Simple to verify selected option.
         * 5. Frequently used in Selenium automation.
         *
         * Disadvantages:
         *
         * 1. Only one option can be selected.
         * 2. Dynamic locators may change.
         * 3. Wrong locator may select the wrong option.
         *
         * Best Use:
         *
         * - Gender Selection
         * - Payment Method
         * - Shipping Options
         * - Survey Forms
         * - Registration Forms
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

        // Locate all radio buttons
        List<WebElement> radioButtons = driver.findElements(
                By.xpath("//input[@type='radio']"));

        /*
         * ============================================================
         * Approach 1 : Print All Radio Buttons
         * ============================================================
         */

        System.out.println("Total Radio Buttons : " + radioButtons.size());

        for (WebElement radio : radioButtons) {

            String id = radio.getAttribute("id");
            System.out.println(id);
        }

        /*
         * ============================================================
         * Approach 2 : Select Male Radio Button
         * ============================================================
         */

        for (WebElement radio : radioButtons) {

            String id = radio.getAttribute("id");

            if (id.equals("male")) {

                System.out.println("\nSelecting : " + id);

                radio.click();

                break;
            }
        }

        /*
         * ============================================================
         * Approach 3 : Verify Selected Radio Button
         * ============================================================
         */

        for (WebElement radio : radioButtons) {

            if (radio.isSelected()) {

                System.out.println("Selected Radio Button : "
                        + radio.getAttribute("id"));
            }
        }

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}
