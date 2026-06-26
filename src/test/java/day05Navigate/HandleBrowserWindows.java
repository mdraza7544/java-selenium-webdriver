package day05Navigate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleBrowserWindows {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle Browser Windows in Selenium
         * ============================================================
         *
         * Definition:
         * Browser Window Handling is used to switch control
         * between multiple browser windows or tabs.
         *
         * When a new window or tab opens, Selenium stays on
         * the parent window. We must switch to the new window
         * before performing any action.
         *
         * Methods Used:
         *
         * 1. getWindowHandle()
         *    - Returns the ID of the current browser window.
         *
         * 2. getWindowHandles()
         *    - Returns the IDs of all opened browser windows.
         *
         * 3. switchTo().window(windowID)
         *    - Switches control to the specified browser window.
         *
         * Where are these methods found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebDriver
         * Methods   :
         *    - getWindowHandle()
         *    - getWindowHandles()
         *    - switchTo().window()
         *
         * Advantages:
         *
         * 1. Easy to switch between browser windows.
         * 2. Supports multiple tabs and windows.
         * 3. Useful for payment gateways and social login.
         * 4. Helps automate pop-up windows.
         * 5. Required in real Selenium automation projects.
         *
         * Disadvantages:
         *
         * 1. Window IDs are random and change every execution.
         * 2. Wrong window selection may fail the test.
         * 3. Must switch to the correct window before performing actions.
         * 4. More code is required for multiple windows.
         * 5. Beginners may find window handling confusing.
         *
         * Best Use:
         *
         * - Child browser windows
         * - Multiple browser tabs
         * - Payment gateway pages
         * - Social media login windows
         * - Advertisement pop-ups
         *
         * ============================================================
         */

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Maximize browser window
        driver.manage().window().maximize();

        // Open OrangeHRM Demo Website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Print Parent Window Title
        System.out.println("Parent Window Title : " + driver.getTitle());

        // Click the OrangeHRM link
        // This opens a new browser window
        driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();

        // Get all browser window IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Convert Set into List
        // This allows us to access windows using index values
        List<String> windowList = new ArrayList<>(windowIds);

        /*
         * ============================================================
         * Approach 1 : Switch Window Using List Index
         * ============================================================
         */

        // Switch to Parent Window
        driver.switchTo().window(windowList.get(0));

        System.out.println("\n========== Parent Window ==========");
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL   : " + driver.getCurrentUrl());

        // Switch to Child Window
        driver.switchTo().window(windowList.get(1));

        System.out.println("\n========== Child Window ==========");
        System.out.println("Title : " + driver.getTitle());
        System.out.println("URL   : " + driver.getCurrentUrl());

        /*
         * ============================================================
         * Approach 2 : Switch Window Using For-Each Loop
         * ============================================================
         */

        for (String windowId : windowIds) {

            // Switch to each browser window
            driver.switchTo().window(windowId);

            // Get the current window title
            String title = driver.getTitle();

            // Check whether it is the parent or child window
            if (title.equals("OrangeHRM")) {

                System.out.println("\n========== Parent Window ==========");
                System.out.println("Title : " + driver.getTitle());
                System.out.println("URL   : " + driver.getCurrentUrl());

            } else {

                System.out.println("\n========== Child Window ==========");
                System.out.println("Title : " + driver.getTitle());
                System.out.println("URL   : " + driver.getCurrentUrl());
            }
        }

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}