package day3WebdriverMethods;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class GetMethods {

    public static void main(String[] args) throws InterruptedException {

        // Launch Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open URL
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Print title and URL
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Current URL: " + driver.getCurrentUrl());
        
        Thread.sleep(5000);
       

        // Click on OrangeHRM link
        driver.findElement(By.xpath("//a[@href='http://www.orangehrm.com']")).click();

        // Wait for new window/tab to open
        Thread.sleep(3000);

        // Get all window IDs
        Set<String> windowIds = driver.getWindowHandles();

        // Print all window IDs
        for (String windowId : windowIds) {
            System.out.println("Window ID: " + windowId);
        }

        // Close browser
        driver.quit();
    }
}