package day02Locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator5 {
	public static void main(String[] args) throws InterruptedException {


        // Open Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        // Wait for page to load
        Thread.sleep(3000);
        

        // RELATIVE XPATH BY ATTRIBUTE
        // Syntax: //tagName[@attribute='value']
        driver.findElement(By.xpath("//input[@name='username']"))
              .sendKeys("Admin");

        // RELATIVE XPATH BY ANOTHER ATTRIBUTE
        driver.findElement(By.xpath("//input[@name='password']"))
              .sendKeys("admin123");

        // RELATIVE XPATH USING MULTIPLE ATTRIBUTES (AND)
        // Syntax: //tagName[@attr1='value1' and @attr2='value2']
        driver.findElement(By.xpath("//button[@type='submit' and contains(@class,'orangehrm-login-button')]"))
              .click();

        // Wait for dashboard page
        Thread.sleep(3000);
		
        // PARENT AXIS
        // Select parent element of username field
        driver.findElement(By.xpath("//input[@name='username']/parent::div"));

        // ANCESTOR AXIS
        // Select ancestor element of username field
        driver.findElement(By.xpath("//input[@name='username']/ancestor::form"));

        // SELF AXIS
        // Select current element itself
        driver.findElement(By.xpath("//input[@name='username']/self::input"));

        // DESCENDANT AXIS
        // Select all input elements inside form
        driver.findElement(By.xpath("//form/descendant::input"));


        // FOLLOWING AXIS
        // Select elements after current element
        driver.findElement(By.xpath("//input[@name='username']/following::input"));

        // PRECEDING AXIS
        // Select elements before current element
        driver.findElement(By.xpath("//input[@name='password']/preceding::input"));
	}
}
