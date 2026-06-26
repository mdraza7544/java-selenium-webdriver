package day03WebdriverMethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ConditionalMethods {

    public static void main(String[] args) throws InterruptedException {

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Open OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        Thread.sleep(3000);

        // Username field
        WebElement username = driver.findElement(By.name("username"));
        System.out.println("Username Displayed: " + username.isDisplayed());
        System.out.println("Username Enabled: " + username.isEnabled());
        username.sendKeys("Admin");

        // Password field
        WebElement password = driver.findElement(By.name("password"));
        System.out.println("Password Displayed: " + password.isDisplayed());
        System.out.println("Password Enabled: " + password.isEnabled());
        password.sendKeys("admin123");

        // Login button
        WebElement loginBtn = driver.findElement(By.xpath("//button[@type='submit']"));
        System.out.println("Login Button Displayed: " + loginBtn.isDisplayed());
        System.out.println("Login Button Enabled: " + loginBtn.isEnabled());

        loginBtn.click();

        Thread.sleep(5000);

        // Click Admin Menu
        WebElement adminMenu = driver.findElement(By.xpath("//span[text()='Admin']"));

        System.out.println("Admin Menu Displayed: " + adminMenu.isDisplayed());
        System.out.println("Admin Menu Enabled: " + adminMenu.isEnabled());

        adminMenu.click();

        Thread.sleep(3000);

        // Select first checkbox from User Management table
        WebElement checkbox = driver.findElement(
                By.xpath("(//span[contains(@class,'oxd-checkbox-input')])[2]"));

        System.out.println("Checkbox Displayed: " + checkbox.isDisplayed());
        System.out.println("Checkbox Enabled: " + checkbox.isEnabled());

        // Click checkbox
        checkbox.click();

        System.out.println("Checkbox clicked successfully");

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}