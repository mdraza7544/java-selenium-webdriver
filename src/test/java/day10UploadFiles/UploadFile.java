package day10UploadFiles;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class UploadFile {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Upload File in Selenium
         * ============================================================
         *
         * Definition:
         * File Upload is the process of uploading a file from the
         * local machine to a web application.
         *
         * Selenium uploads a file by sending the complete file path
         * to an HTML <input type="file"> element using sendKeys().
         *
         * Methods Used:
         *
         * 1. sendKeys()
         *    - Sends the complete file path to the file input element.
         *
         * 2. click()
         *    - Can be used to submit the uploaded file (if required).
         *
         * Where are these methods found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebElement
         * Methods   :
         *    - sendKeys()
         *    - click()
         *
         * Advantages:
         *
         * 1. Easy to automate file uploads.
         * 2. No need to use AutoIT or Robot Class for HTML file inputs.
         * 3. Fast and reliable.
         * 4. Commonly used in real-time projects.
         *
         * Disadvantages:
         *
         * 1. Works only with <input type="file"> elements.
         * 2. Cannot handle Windows file upload popups directly.
         *
         * Best Use:
         *
         * - Resume Upload
         * - Profile Picture Upload
         * - Document Upload
         * - Image Upload
         * - Attachment Upload
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open DemoQA Upload & Download Page
        driver.get("https://demoqa.com/upload-download");

        /*
         * ============================================================
         * Approach 1 : Upload File Using sendKeys()
         * ============================================================
         */

        // Store the file path
        String filePath = "C:\\Users\\mdash\\OneDrive\\Desktop\\STUDENT_RECORD_MANAGEMENT_SYSTEM.md";

        // Locate the file upload element and upload the file
        driver.findElement(By.id("uploadFile")).sendKeys(filePath);

        // Print success message
        System.out.println("File Uploaded Successfully.");

        // Close all browser windows and end the WebDriver session
        driver.quit();
    }
}