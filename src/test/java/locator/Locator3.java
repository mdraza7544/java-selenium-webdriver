package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator3{

    public static void main(String[] args) throws InterruptedException {

        // Open Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open SauceDemo website
        driver.get("https://www.saucedemo.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        // CSS Selector by ID (#)
        driver.findElement(By.cssSelector("#user-name"))
              .sendKeys("standard_user");

        // CSS Selector by Attribute
        driver.findElement(By.cssSelector("[name='password']"))
              .sendKeys("secret_sauce");

        // CSS Selector by Tag + ID
        driver.findElement(By.cssSelector("input#login-button"))
              .click();

        Thread.sleep(2000);

        // CSS Selector by Class
        driver.findElement(By.cssSelector(".inventory_item_name"))
              .click();

        Thread.sleep(2000);

        // Go back to products page
        driver.navigate().back();

        // CSS Selector by Multiple Classes
        driver.findElement(By.cssSelector(".inventory_item_name"))
              .click();

        Thread.sleep(2000);

        // Go back to products page
        driver.navigate().back();

        Thread.sleep(5000);

        // Close browser
        driver.quit();
    }
}