package locator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Locator4{

    public static void main(String[] args) throws InterruptedException {

        // Open Firefox browser
        WebDriver driver = new FirefoxDriver();

        // Open OrangeHRM website
        driver.get("https://opensource-demo.orangehrmlive.com/");

        // Maximize browser window
        driver.manage().window().maximize();

        // Wait for page to load
        Thread.sleep(3000);

        // ABSOLUTE XPATH
        // Uses complete path from root element
        // Not recommended because it breaks easily
        // driver.findElement(By.xpath("/html/body/div/div/div/div/div/div[2]/div[2]/form/div[1]/div/div[2]/input"))
        //       .sendKeys("Admin");


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

        // RELATIVE XPATH BY TEXT
        // Syntax: //tagName[text()='text']
        driver.findElement(By.xpath("//span[text()='PIM']"))
              .click();

        Thread.sleep(2000);

        // Go back to dashboard
        driver.navigate().back();

        // RELATIVE XPATH USING CONTAINS
        // Syntax: //tagName[contains(@attribute,'value')]
        driver.findElement(By.xpath("//a[contains(@href,'viewMyDetails')]"))
              .click();

        Thread.sleep(2000);

        // Go back to dashboard
        driver.navigate().back();

        // RELATIVE XPATH USING STARTS-WITH
        // Syntax: //tagName[starts-with(@attribute,'value')]
        driver.findElement(By.xpath("//div[starts-with(@class,'oxd-layout')]"));

        // RELATIVE XPATH USING OR
        // Syntax: //tagName[@attr1='value1' or @attr2='value2']
        driver.findElement(By.xpath("//input[@name='username' or @placeholder='Username']"));

        // INDEXING
        // Select second input field
        // Syntax: (//tagName)[index]
        driver.findElement(By.xpath("(//input)[2]"));

        // LAST ELEMENT
        // Select last input element
        // Syntax: (//tagName)[last()]
        driver.findElement(By.xpath("(//input)[last()]"));

        // Wait for 5 seconds
        Thread.sleep(5000);

        // Close browser
        driver.quit();
    }
}