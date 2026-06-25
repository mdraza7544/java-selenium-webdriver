package day3WebdriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserMethods {

    public static void main(String[] args) throws InterruptedException {

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open OrangeHRM application
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // Store parent window ID
        String parentWindow = driver.getWindowHandle();

        // Click OrangeHRM, Inc link (opens new tab/window)
        driver.findElement(By.xpath("//a[contains(text(),'OrangeHRM, Inc')]")).click();

        Thread.sleep(3000);

        // Get all window IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Switch to child window
        for (String windowId : windowIds) {

            if (!windowId.equals(parentWindow)) {

                driver.switchTo().window(windowId);

                System.out.println("Child Window Title: " + driver.getTitle());

                // close() -> closes only current child window
                driver.close();

                System.out.println("Child window closed using close()");
            }
        }

        // Switch back to parent window
        driver.switchTo().window(parentWindow);

        System.out.println("Parent Window Title: " + driver.getTitle());

        Thread.sleep(2000);

        // quit() -> closes all remaining windows and ends session
        driver.quit();

        System.out.println("All browser windows closed using quit()");
    }
}