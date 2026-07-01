package day06DropDown;

import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HiddenDropdown {
	public static void main(String[] args) {
        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Set Implicit Wait for 10 seconds
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Create URL object for OrangeHRM
        driver.get("https://opensource-demo.orangehrmlive.com/");
        
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
        
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
        
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        
        driver.findElement(By.xpath("//span[text()='PIM']")).click();
        
	}
}
