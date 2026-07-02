package day12HTMLTable;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandleWebTable {

    public static void main(String[] args) {

        /*
         * ============================================================
         * Handle HTML Web Table in Selenium
         * ============================================================
         *
         * Definition:
         * A Web Table is an HTML table used to display data
         * in rows and columns.
         *
         * Selenium allows us to read, verify, search,
         * and manipulate table data using XPath.
         *
         * Methods Used:
         *
         * 1. findElement()
         *    - Finds a single web element.
         *
         * 2. findElements()
         *    - Finds multiple web elements.
         *
         * 3. getText()
         *    - Retrieves the text of an element.
         *
         * Where are these methods found?
         *
         * Package   : org.openqa.selenium
         * Interface : WebDriver / WebElement
         *
         * Advantages:
         *
         * 1. Reads table data dynamically.
         * 2. Verifies rows and columns.
         * 3. Searches specific records.
         * 4. Useful for reports and data validation.
         *
         * Best Use:
         *
         * - Employee Tables
         * - Product Lists
         * - Student Records
         * - Order History
         *
         * ============================================================
         */

        // Launch Firefox Browser
        WebDriver driver = new FirefoxDriver();

        // Maximize Browser Window
        driver.manage().window().maximize();

        // Set Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open Test Automation Practice Website
        driver.get("https://testautomationpractice.blogspot.com/");

        /*
         * ============================================================
         * Approach 1 : Count Total Rows
         * ============================================================
         */

        List<WebElement> rows =
                driver.findElements(By.xpath("//table[@name='BookTable']//tr"));

        System.out.println("Total Rows : " + rows.size());

        /*
         * ============================================================
         * Approach 2 : Count Total Columns
         * ============================================================
         */

        List<WebElement> columns =
                driver.findElements(By.xpath("//table[@name='BookTable']//tr[1]/th"));

        System.out.println("Total Columns : " + columns.size());

        /*
         * ============================================================
         * Approach 3 : Read Specific Cell
         * ============================================================
         */

        String data = driver.findElement(
                By.xpath("//table[@name='BookTable']//tr[3]/td[2]"))
                .getText();

        System.out.println("Cell Data : " + data);

        /*
         * ============================================================
         * Approach 4 : Print Complete Table
         * ============================================================
         */

        System.out.println("\n========== Complete Table ==========");

        for (int r = 2; r <= rows.size(); r++) {

            for (int c = 1; c <= columns.size(); c++) {

                String value = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[" + c + "]"))
                        .getText();

                System.out.print(value + "\t");
            }

            System.out.println();
        }

        /*
         * ============================================================
         * Approach 5 : Print Book Names Written by Mukesh
         * ============================================================
         */

        System.out.println("\nBooks Written By Mukesh");

        for (int r = 2; r <= rows.size(); r++) {

            String author = driver.findElement(
                    By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[2]"))
                    .getText();

            if (author.equals("Mukesh")) {

                String bookName = driver.findElement(
                        By.xpath("//table[@name='BookTable']//tr[" + r + "]/td[1]"))
                        .getText();

                System.out.println(bookName);
            }
        }

        // Close Browser
        driver.quit();
    }
}