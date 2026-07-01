package day10UploadFiles;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class RobotClass {

    public static void main(String[] args) throws AWTException, InterruptedException {

        /*
         * ============================================================
         * Upload File Using Robot Class
         * ============================================================
         *
         * Definition:
         * Robot Class is used to automate native keyboard and
         * mouse events at the operating system level.
         *
         * It is mainly used when Selenium cannot directly
         * interact with the Windows File Upload dialog.
         *
         * Package :
         * java.awt
         *
         * Class :
         * Robot
         *
         * Methods Used:
         *
         * 1. StringSelection()
         * 2. Toolkit.getDefaultToolkit()
         * 3. keyPress()
         * 4. keyRelease()
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Upload Website
        driver.get("https://the-internet.herokuapp.com/upload");

        /*
         * ============================================================
         * Approach 1 : Upload File Using Robot Class
         * ============================================================
         */

        // Click Choose File button
        driver.findElement(By.id("file-upload")).click();

        Thread.sleep(2000);

        // File path
        String filePath = "C:\\Users\\mdash\\OneDrive\\Desktop\\STUDENT_RECORD_MANAGEMENT_SYSTEM.md";

        // Copy file path to clipboard
        StringSelection selection = new StringSelection(filePath);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

        // Create Robot object
        Robot robot = new Robot();

        // Press CTRL + V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(1000);

        // Press ENTER
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        // Click Upload Button
        driver.findElement(By.id("file-submit")).click();

        System.out.println("File Uploaded Successfully.");

        Thread.sleep(3000);

        // Close Browser
        driver.quit();
    }
}