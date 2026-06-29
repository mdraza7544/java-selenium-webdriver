package day6DropDown;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropdown {

    public static void main(String[] args) {

        // Launch Chrome Browser
        WebDriver driver = new ChromeDriver();

        // Maximize Browser
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Website
        driver.get("https://chromatechacademy.net/selenium-practice/");

        // Click Bootstrap Dropdown
        driver.findElement(By.xpath("//button[contains(text(),'Dropdown button')]")).click();

        // Capture all dropdown options
        List<WebElement> options = driver.findElements(
                By.xpath("//div[contains(@class,'dropdown-menu')]"));

        // Print total options
        System.out.println("Total Options : " + options.size());

        // Print all options
        System.out.println("\nDropdown Options:");
        for (WebElement option : options) {
            System.out.println(option.getText());
        }

        // Select a specific option
        String expectedOption = "Dropdown link";

        for (WebElement option : options) {

            if (option.getText().equals(expectedOption)) {

                System.out.println("\nOption Found : " + option.getText());

                option.click();

                System.out.println("Option Selected Successfully.");

                break;
            }
        }

        // Close Browser
//        driver.quit();
    }
}

//button[contains(@class,'btn-outline-light')]