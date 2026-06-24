package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator1 {

    public static void main(String[] args) {

        // Create Firefox browser object
        WebDriver driver = new FirefoxDriver();

        // Open the SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Maximize the browser window
        driver.manage().window().maximize();

        // Find the username field by id and enter the username
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        // Find the password field by name and enter the password
        driver.findElement(By.name("password")).sendKeys("secret_sauce");

        // Find the login button by class name and click on it
        driver.findElement(By.className("submit-button")).click();

        // Close the browser
        driver.quit();
    }
}