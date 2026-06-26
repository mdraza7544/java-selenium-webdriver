package day05Navigate;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NavigationMethods {

    public static void main(String[] args) throws MalformedURLException {

        /*
         * ============================================================
         * Navigation Methods in Selenium
         * ============================================================
         *
         * Definition:
         * Navigation methods are used to move from one web page
         * to another or perform browser operations like
         * Open URL, Back, Forward, and Refresh.
         *
         * Navigation methods are available through
         * driver.navigate().
         *
         * Syntax:
         *
         * driver.navigate().to("https://example.com");
         * driver.navigate().back();
         * driver.navigate().forward();
         * driver.navigate().refresh();
         *
         * OR
         *
         * URL url = new URL("https://example.com");
         * driver.navigate().to(url);
         *
         * Where is it found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebDriver
         * Method    : navigate()
         * Return    : Navigation Interface
         *
         * Navigation Methods:
         *
         * 1. to()       -> Opens a URL.
         * 2. back()     -> Goes to the previous page.
         * 3. forward()  -> Goes to the next page.
         * 4. refresh()  -> Reloads the current page.
         *
         * Advantages:
         *
         * 1. Easy to navigate between pages.
         * 2. Simulates browser navigation.
         * 3. Useful for testing browser history.
         * 4. Supports both String and URL objects.
         * 5. Easy to refresh the page.
         *
         * Disadvantages:
         *
         * 1. back() and forward() require browser history.
         * 2. refresh() reloads the complete page.
         * 3. Does not wait for elements automatically.
         * 4. Additional waits may be needed.
         * 5. Wrong navigation flow may fail the test.
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Set Implicit Wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create URL object for Google
        URL google = new URL("https://www.google.com");

        // Create URL object for OrangeHRM
        URL orangeHRM = new URL("https://opensource-demo.orangehrmlive.com/");

        // Open Google website
        driver.navigate().to(google);

        // Open OrangeHRM website
        driver.navigate().to(orangeHRM);

        // Go back to Google
        driver.navigate().back();

        // Go forward to OrangeHRM
        driver.navigate().forward();

        // Refresh the current page
        driver.navigate().refresh();

        // Close all browser windows
        driver.quit();
    }
}